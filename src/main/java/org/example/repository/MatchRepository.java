package org.example.repository;

import org.example.model.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anatoliy Shikin
 */
public interface MatchRepository extends JpaRepository<Match, Long> {
}
