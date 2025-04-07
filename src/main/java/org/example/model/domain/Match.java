package org.example.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Anatoliy Shikin
 */
@Entity
@Table(name = "match")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "season")
    private String season;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "owner_team_id", referencedColumnName = "id")
    private Team ownerTeam;

    @OneToOne
    @JoinColumn(name = "guest_team_id", referencedColumnName = "id")
    private Team guestTeam;

    @Column(name = "owner_points")
    private Integer ownerPoints;

    @Column(name = "guest_points")
    private Integer guestPoints;
}
