package org.example.repository;

import org.example.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Anatoliy Shikin
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByLastName(String lastName);

    Optional<Player> findByFirstNameAndLastName(String firstName, String lastName);
}
