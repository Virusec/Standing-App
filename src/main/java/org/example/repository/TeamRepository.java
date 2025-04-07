package org.example.repository;

import org.example.model.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anatoliy Shikin
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
}
