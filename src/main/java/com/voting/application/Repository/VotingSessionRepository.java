package com.voting.application.Repository;

import com.voting.application.Entity.VotingSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotingSessionRepository extends JpaRepository<VotingSessionEntity, Long> {
    Optional<VotingSessionEntity> findByActiveTrue();
}
