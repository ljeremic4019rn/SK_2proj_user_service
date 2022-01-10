package service;

import dto.RankCreateDto;
import dto.RankDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankService {

    Page<RankDto> findByUserId (Long userId, Pageable pageable);

    Page<RankDto> findAll(Pageable pageable);

    RankDto add(RankCreateDto rankCreateDto);

    RankDto findById(Long id);

    void deleteById(Long id);
}
