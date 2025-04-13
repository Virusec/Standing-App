package org.example.repository;

import org.example.model.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Anatoliy Shikin
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String name);
}
