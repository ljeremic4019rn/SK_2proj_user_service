package service;

import dto.TokenRequestDto;
import dto.TokenResponseDto;
import dto.UserCreateDto;
import dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    UserDto add(UserCreateDto userCreateDto);

    UserDto findById(Long id);

    void deleteById(Long id);

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

    //token todo dodaj jos stvari/ promeni format kako izgleda

}
