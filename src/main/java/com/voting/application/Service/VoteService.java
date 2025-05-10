package com.voting.application.Service;

import com.voting.application.DTO.VoteRequestDto;
import com.voting.application.Entity.CandidateEntity;
import com.voting.application.Entity.VoteEntity;
import com.voting.application.Entity.VoterEntity;
import com.voting.application.Entity.VotingSessionEntity;
import com.voting.application.Exception.VotingException;
import com.voting.application.Repository.CandidateRepository;
import com.voting.application.Repository.VoteRepository;
import com.voting.application.Repository.VoterRepository;
import com.voting.application.Repository.VotingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private VotingSessionRepository votingSessionRepository;

    public void castVote(VoteRequestDto voteRequestDto) {

        VotingSessionEntity session = votingSessionRepository.findByActiveTrue()
                .orElseThrow(() -> new VotingException("No active voting session", HttpStatus.NOT_FOUND));

        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(session.getStartTime()) || now.isAfter(session.getEndTime())) {
            throw new VotingException("Voting is not allowed at this time", HttpStatus.FORBIDDEN);
        }

        VoterEntity voter = voterRepository.findById(voteRequestDto.getVoterId())
                .orElseThrow(() -> new VotingException("Voter not found", HttpStatus.NOT_FOUND));

        if (Boolean.TRUE.equals(voter.getHasVoted())) {
            throw new VotingException("Voter has already voted", HttpStatus.CONFLICT);
        }


        CandidateEntity candidateEntity = candidateRepository.findById(voteRequestDto.getCandidateId())
                .orElseThrow(() -> new VotingException("Candidate not found", HttpStatus.NOT_FOUND));

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setCandidate(candidateEntity);
        voteEntity.setVoter(voter);
        voteEntity.setTimestamp(LocalDateTime.now());
        voteRepository.save(voteEntity);

        voter.setHasVoted(true);
        voterRepository.save(voter);
    }
}
