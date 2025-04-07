package org.example.repository;

import org.example.model.domain.Standing;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anatoliy Shikin
 */
public interface StandingRepository extends JpaRepository<Standing, Long> {
}
