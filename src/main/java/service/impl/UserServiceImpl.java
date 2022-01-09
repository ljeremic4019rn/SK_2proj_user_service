package service.impl;

import dto.UserHolderCreateDto;
import dto.UserHolderDto;
import mapper.UserHolderMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.UserHolderRepository;
import service.UserHolderService;

public class UserServiceImpl implements UserHolderService {

   // private TokenService tokenService;
    private UserHolderRepository userHolderRepository;
    private UserHolderMapper userHolderMapper;


    public UserServiceImpl(UserHolderRepository userHolderRepository, UserHolderMapper userHolderMapper) {
        this.userHolderRepository = userHolderRepository;
        this.userHolderMapper = userHolderMapper;
    }

    @Override
    public Page<UserHolderDto> findAll(Pageable pageable) {
        return userHolderRepository.findAll(pageable)
                .map(userHolderMapper::userHolderToUserHolderDto);
    }

    @Override
    public UserHolderDto add(UserHolderCreateDto userHolderCreateDto) {
        return null;
    }
}
