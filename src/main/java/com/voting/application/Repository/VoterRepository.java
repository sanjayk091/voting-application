package com.voting.application.Repository;

import com.voting.application.Entity.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterEntity, String> {
}
