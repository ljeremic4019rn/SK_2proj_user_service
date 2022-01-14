package app.service.impl;

import app.domain.User;
import app.dto.TokenRequestDto;
import app.dto.TokenResponseDto;
import app.dto.UserCreateDto;
import app.dto.UserDto;
import app.dto.notificationDtos.UserPasswordDto;
import app.exception.NotFoundException;
import app.messageHelper.MessageHelper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import app.repository.UserRepository;
import app.security.service.TokenService;
import app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private UserMapper userMapper;

    private JmsTemplate jmsTemplate;
    private String destinationResetPass;
    private String destinationVerifyMail;
    private MessageHelper messageHelper;
    
    List<UserPasswordDto> newPasswordList;

    public UserServiceImpl(TokenService tokenService, UserRepository userRepository, UserMapper userMapper,
                           JmsTemplate jmsTemplate, @Value("${destination.resetPass}") String  destinationResetPass, @Value("${destination.verifyMail}") String  destinationVerifyMail,
                           MessageHelper messageHelper, List<UserPasswordDto> newPasswordList) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jmsTemplate = jmsTemplate;
        this.destinationResetPass = destinationResetPass;
        this.destinationVerifyMail = destinationVerifyMail;
        this.messageHelper = messageHelper;
        this.newPasswordList = newPasswordList;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::userToUserDto);
    }

    @Override
    public UserDto add(UserCreateDto userCreateDto) {
        User user = userMapper.userCreateDtoToUser(userCreateDto);
        userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById((id))
                .map(userMapper::userToUserDto)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d not found.", id)));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById((id));//todo dodaj error catcher ako ne nadje usera
    }

    @Override
    public Object login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByEmailAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with username: %s and password: %s not found.", tokenRequestDto.getEmail(),
                                tokenRequestDto.getPassword())));

        if (!user.getAccessEnabled()){
            TokenResponseDto tokenResponseDto = new TokenResponseDto();
            tokenResponseDto.setToken("FORBIDDEN");
            return HttpStatus.FORBIDDEN;
        }

        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("role", user.getRole());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }

    @Override
    public void editAccess(Long id, boolean hasAccess) {
        User user;

         user = userRepository
                 .findById(id)
                 .orElseThrow(() -> new NotFoundException(String.format("User with id: %d not found.", id)));
         user.setAccessEnabled(hasAccess);
         userRepository.save(user);
    }

    @Override
    public void verifyMail(String email) {
        User user = userRepository
                .findUserByEmail(email)
                .orElseThrow(() -> new NotFoundException(String.format("User with email: %s not found.", email)));

        user.setVerifiedMail(true);
        userRepository.save(user);
    }
    
    @Override
    public void changePassword(Long id, UserPasswordDto userPasswordDto) {
        User user = userRepository
                    .findById(id)
                    .orElseThrow(() -> new NotFoundException(String.format("User with id: %d not found.", id)));
        jmsTemplate.convertAndSend(destinationResetPass, messageHelper.createTextMessage(userPasswordDto));
        newPasswordList.add(userPasswordDto);        
    }
    
    @Override
    public void saveNewPassword(Long id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %d not found.", id)));
        
        UserPasswordDto userTmp = null;
        for (UserPasswordDto us:newPasswordList) {
            if(us.getId().equals(user.getId())){
                userTmp = us;
                user.setPassword(us.getPassword());
                break;
            }
        }
        newPasswordList.remove(userTmp);
        
        userRepository.save(user);
    }

}
