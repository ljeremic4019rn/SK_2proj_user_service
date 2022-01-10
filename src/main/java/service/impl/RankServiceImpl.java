package service.impl;

import dto.RankCreateDto;
import dto.RankDto;
import mapper.RankMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.RankRepository;
import service.RankService;

public class RankServiceImpl implements RankService {
    //todo

    private RankRepository rankRepository;
    private RankMapper rankMapper;

    public RankServiceImpl(RankRepository rankRepository, RankMapper rankMapper) {
        this.rankRepository = rankRepository;
        this.rankMapper = rankMapper;
    }

    @Override
    public Page<RankDto> findByUserId(Long userId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RankDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public RankDto add(RankCreateDto rankCreateDto) {
        return null;
    }

    @Override
    public RankDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
