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
//        rankDto.setPoints(rank.getPoints());
        rankDto.setLowerLimit(rank.getLowerLimit());
        rankDto.setUpperLimit(rank.getUpperLimit());
        rankDto.setDiscountPercentage(rank.getDiscountPercentage());
        return rankDto;
    }
    public Rank rankCreateDtoToRank(RankCreateDto rankCreateDto){
        Rank rank = new Rank();
       // rank.setId(rankCreateDto.getId());
        rank.setName(rankCreateDto.getName());
//        rank.setPoints(rankCreateDto.getPoints());
        rank.setLowerLimit(rankCreateDto.getLowerLimit());
        rank.setUpperLimit(rankCreateDto.getUpperLimit());
        rank.setDiscountPercentage(rankCreateDto.getDiscountPercentage());

        return rank;
    }
}
