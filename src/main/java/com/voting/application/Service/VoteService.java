package com.voting.application.Service;

import com.voting.application.DTO.VoteRequestDto;
import com.voting.application.Entity.CandidateEntity;
import com.voting.application.Entity.VoteEntity;
import com.voting.application.Entity.VoterEntity;
import com.voting.application.Repository.CandidateRepository;
import com.voting.application.Repository.VoteRepository;
import com.voting.application.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteService {
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private VoteRepository voteRepository;

    public void castVote(VoteRequestDto voteRequestDto) {
        VoterEntity voter = voterRepository.findById(voteRequestDto.getVoterId()).orElseThrow();
        if(voter.getHasVoted().equals(true)){
            throw new IllegalStateException("Already voted");
        }

        CandidateEntity candidateEntity = candidateRepository.findById(voteRequestDto.getCandidateId())
                .orElseThrow(()-> new RuntimeException("Candidate doesn't exits."));

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setCandidate(candidateEntity);
        voteEntity.setVoter(voter);
        voteEntity.setTimestamp(LocalDateTime.now());
        voteRepository.save(voteEntity);

        voter.setHasVoted(true);
        voterRepository.save(voter);
    }
}
