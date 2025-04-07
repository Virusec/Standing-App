package org.example.repository;

import org.example.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anatoliy Shikin
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByLastName(String lastName);
}
