package com.voting.application.Service;

import com.voting.application.DTO.CandidateRequestDto;
import com.voting.application.DTO.CandidateResponseDto;
import com.voting.application.Entity.CandidateEntity;
import com.voting.application.Exception.VotingException;
import com.voting.application.Mapper.CandidateMapper;
import com.voting.application.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateResponseDto registerCandidate(CandidateRequestDto candidateRequest) {
        if (candidateRepository.existsByEmail(candidateRequest.getEmail())) {
            throw new VotingException("Email is already registered", HttpStatus.CONFLICT);
        }

        if (candidateRepository.existsByMobileNumber(candidateRequest.getMobileNumber())) {
            throw new VotingException("Mobile number is already registered", HttpStatus.CONFLICT);
        }

        if (candidateRepository.existsByPartyNameAndConstituency(
                candidateRequest.getPartyName(), candidateRequest.getConstituency())) {
            throw new VotingException("This party already has a candidate in this constituency", HttpStatus.CONFLICT);
        }

        CandidateEntity candidateEntity = CandidateMapper.toEntity(candidateRequest);
        CandidateEntity candidateSaved = candidateRepository.save(candidateEntity);
        return  CandidateMapper.toDto(candidateSaved);
    }

    public List<CandidateResponseDto> getAllCandidate() {
        List<CandidateEntity> candidateResponse = candidateRepository.findAll();
        return CandidateMapper.toDto(candidateResponse);
    }
}
