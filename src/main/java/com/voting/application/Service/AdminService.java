package com.voting.application.Service;

import com.voting.application.DTO.VotingResultDto;
import com.voting.application.Entity.VoteEntity;
import com.voting.application.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private VoteRepository voteRepository;
    public List<VotingResultDto> getLiveResults() {
        return voteRepository.findAll().stream()
                .map(candidate -> {
                    Long votes = voteRepository.countByCandidateId(candidate.getId());
                    return new VotingResultDto(
                            candidate.getCandidate().getId(),
                            candidate.getCandidate().getName(),
                            candidate.getCandidate().getPartyName(),
                            votes
                    );
                })
                .collect(Collectors.toList());
    }

}
