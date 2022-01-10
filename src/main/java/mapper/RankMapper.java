package mapper;


import domain.Rank;
import dto.RankCreateDto;
import dto.RankDto;

public class RankMapper {

    public RankDto rankToRankDto (Rank rank) {
        RankDto rankDto = new RankDto();
        rankDto.setId(rank.getId());
        rankDto.setRank(rank.getRank());
        rankDto.setPoints(rank.getPoints());
        rankDto.setDiscountPercentage(rank.getDiscountPercentage());
        return rankDto;
    }
    public Rank rankDtoToRank(RankCreateDto rankCreateDto){
        Rank rank = new Rank();
       // rank.setId(rankCreateDto.getId());
        rank.setRank(rankCreateDto.getRank());
        rank.setPoints(rankCreateDto.getPoints());
        rank.setDiscountPercentage(rankCreateDto.getDiscountPercentage());

        return rank;
    }
}
