package app.repository;

import app.domain.Rank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RankRepository extends JpaRepository<Rank, Long> {
    Page<Rank> findRankByUser_id (Long userId, Pageable pageable);
    Optional<Rank> findRankByName (String name);
}
