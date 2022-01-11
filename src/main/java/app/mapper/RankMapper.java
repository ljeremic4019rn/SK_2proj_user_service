package app.mapper;


import app.domain.Rank;
import app.dto.RankCreateDto;
import app.dto.RankDto;
import org.springframework.stereotype.Component;

@Component
public class RankMapper {

    public RankDto rankToRankDto (Rank rank) {
        RankDto rankDto = new RankDto();
        rankDto.setId(rank.getId());
        rankDto.setName(rank.getName());
        rankDto.setPoints(rank.getPoints());
        rankDto.setDiscountPercentage(rank.getDiscountPercentage());
        return rankDto;
    }
    public Rank rankCreateDtoToRank(RankCreateDto rankCreateDto){
        Rank rank = new Rank();
       // rank.setId(rankCreateDto.getId());
        rank.setName(rankCreateDto.getName());
        rank.setPoints(rankCreateDto.getPoints());
        rank.setDiscountPercentage(rankCreateDto.getDiscountPercentage());

        return rank;
    }
}
