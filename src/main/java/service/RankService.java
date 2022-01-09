package service;

import dto.RankDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankService {

    Page<RankDto> findByUserId (Long userId, Pageable pageable);

}
