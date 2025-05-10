package com.voting.application.Service;

import com.voting.application.DTO.VotingSessionRequestDto;
import com.voting.application.DTO.VotingSessionResponseDto;
import com.voting.application.Entity.VotingSessionEntity;
import com.voting.application.Mapper.VotingSessionMapper;
import com.voting.application.Repository.VotingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingSessionService {
    @Autowired
    private VotingSessionRepository votingSessionRepository;
    public VotingSessionResponseDto startSession(VotingSessionRequestDto votingSessionDto) {
        VotingSessionEntity votingSession = VotingSessionMapper.toEntity(votingSessionDto);
        VotingSessionEntity votingSessionEntity = votingSessionRepository.save(votingSession);
        return VotingSessionMapper.toDto(votingSessionEntity);
    }

    public void endSession(Long id) {
        VotingSessionEntity session = votingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
        session.setActive(false);
        votingSessionRepository.save(session);
    }
}
