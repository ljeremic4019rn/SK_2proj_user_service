package service.impl;

import dto.UserCreateDto;
import dto.UserDto;
import mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.UserRepository;
import service.UserService;

public class UserServiceImpl implements UserService {

   // private TokenService tokenService;
    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::userHolderToUserHolderDto);
    }

    @Override
    public UserDto add(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
