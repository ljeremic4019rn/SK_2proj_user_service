package app.service;

import app.dto.TokenRequestDto;
import app.dto.UserCreateDto;
import app.dto.UserDto;
import app.dto.notificationDtos.UserPasswordDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    UserDto add(UserCreateDto userCreateDto);

    UserDto findById(Long id);

    void deleteById(Long id);

    Object login(TokenRequestDto tokenRequestDto);

    void editAccess (Long id, boolean hasAccess);

//    UserDto updateClientProfile(Long id, dto dto); //todo

    void verifyMail(String email);

    void changePassword(Long id, UserPasswordDto userPasswordDto);

    void saveNewPassword(Long id);


}
