package service.impl;

import domain.Rank;
import dto.RankCreateDto;
import dto.RankDto;
import exception.NotFoundException;
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
        return rankRepository.findRankByUser_id(userId, pageable)
                .map(rankMapper::rankToRankDto);
    }

    @Override
    public Page<RankDto> findAll(Pageable pageable) {
        return rankRepository.findAll(pageable)
                .map(rankMapper::rankToRankDto);
    }

    @Override
    public RankDto add(RankCreateDto rankCreateDto) {
        Rank rank = rankMapper.rankCreateDtoToRank(rankCreateDto);
        rankRepository.save(rank);
        return rankMapper.rankToRankDto(rank);
    }

    @Override
    public RankDto findById(Long id) {
        return rankRepository.findById((id))
                .map(rankMapper::rankToRankDto)
                .orElseThrow(() -> new NotFoundException(String.format("Admin with id: %d not found.", id)));
    }

    @Override
    public void deleteById(Long id) {
        rankRepository.deleteById((id));
    }
}
