package com.voting.application.Repository;

import com.voting.application.Entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {
    Long countByCandidateId(Long id);
}
