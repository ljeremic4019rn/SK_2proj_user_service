package service.impl;

import domain.User;
import dto.TokenRequestDto;
import dto.TokenResponseDto;
import dto.UserCreateDto;
import dto.UserDto;
import exception.NotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.UserRepository;
import security.service.TokenService;
import service.UserService;

public class UserServiceImpl implements UserService {

    private TokenService tokenService;
    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
    public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
        //Try to find active user for specified credentials
        User user = userRepository
                .findUserByUsernameAndPassword(tokenRequestDto.getUsername(), tokenRequestDto.getPassword())
                .orElseThrow(() -> new NotFoundException(String
                        .format("User with username: %s and password: %s not found.", tokenRequestDto.getUsername(),
                                tokenRequestDto.getPassword())));
        //Create token payload
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("role", user.getRole());
        //Generate token
        return new TokenResponseDto(tokenService.generate(claims));
    }
}
