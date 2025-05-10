package com.voting.application.Repository;

import com.voting.application.Entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, String> {
    boolean existsByMobileNumber(String mobileNumber);
    boolean existsByEmail(String email);
    boolean existsByPartyNameAndConstituency(String partyName, String constituency);
}
