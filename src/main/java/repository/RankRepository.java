package repository;

import domain.Rank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Page<Rank> findRankByUser_id (Long userId, Pageable pageable);
}
