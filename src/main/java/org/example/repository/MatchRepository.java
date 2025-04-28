package org.example.repository;

import org.example.model.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Anatoliy Shikin
 */
public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query(value = "SELECT m.* " +
            "FROM match m " +
            "JOIN team o ON m.owner_team_id = o.id " +
            "JOIN team g ON m.guest_team_id = g.id " +
            "WHERE (o.name = :name OR g.name = :name) " +
            " AND m.date <= :dt",
            nativeQuery = true
    )
    List<Match> findByOwnerTeamName(@Param("name") String name, @Param("dt") LocalDate localDate);
}
