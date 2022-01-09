package service;

import dto.UserHolderCreateDto;
import dto.UserHolderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserHolderService {
    Page<UserHolderDto> findAll(Pageable pageable);

    UserHolderDto add(UserHolderCreateDto userHolderCreateDto);

    //token todo dodaj jos stvari/ promeni format kako izgleda

}
