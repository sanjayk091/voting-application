package com.voting.application.Repository;

import com.voting.application.Entity.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterEntity, String> {
    boolean existsByMobileNumber(String mobileNumber);
    boolean existsByEmail(String email);
    boolean existsByGovernmentId(String governmentId);
}
