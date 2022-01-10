package service;

import dto.UserCreateDto;
import dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    UserDto add(UserCreateDto userCreateDto);

    UserDto findById(Long id);

    void deleteById(Long id);
    //token todo dodaj jos stvari/ promeni format kako izgleda

}
