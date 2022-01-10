package mapper;


import domain.Rank;
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
    public Rank rankDtoToRank(RankDto rankDto){
        Rank rank = new Rank();
        rank.setId(rankDto.getId());
        rank.setRank(rankDto.getRank());
        rank.setPoints(rankDto.getPoints());
        rank.setDiscountPercentage(rankDto.getDiscountPercentage());

        return rank;
    }
}
