package com.voting.application.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "votes")
@NoArgsConstructor
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private VoterEntity voter;

    @ManyToOne
    private CandidateEntity candidate;
    private LocalDateTime timestamp;
}
