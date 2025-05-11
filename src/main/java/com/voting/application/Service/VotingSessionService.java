package com.voting.application.Service;

import com.voting.application.DTO.VotingSessionRequestDto;
import com.voting.application.DTO.VotingSessionResponseDto;
import com.voting.application.Entity.VotingSessionEntity;
import com.voting.application.Exception.VotingException;
import com.voting.application.Mapper.VotingSessionMapper;
import com.voting.application.Repository.VotingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class VotingSessionService {
    @Autowired
    private VotingSessionRepository votingSessionRepository;

    public VotingSessionResponseDto startSession(VotingSessionRequestDto votingSessionDto) {

        // check Active session
        checkForActiveSession();

        VotingSessionEntity newSession = VotingSessionMapper.toEntity(votingSessionDto);
        newSession.setActive(true); // explicitly mark it as active
        VotingSessionEntity savedSession = votingSessionRepository.save(newSession);

        return VotingSessionMapper.toDto(savedSession);
    }

    public void endSession() {
        VotingSessionEntity activeSession = votingSessionRepository.findByActiveTrue()
                .orElseThrow(() -> new VotingException("Active session not found", HttpStatus.NOT_FOUND));

        activeSession.setActive(false);
        votingSessionRepository.save(activeSession);
    }

    private void checkForActiveSession() {
        votingSessionRepository.findByActiveTrue().ifPresent(session -> {
            throw new VotingException("An active voting session already exists.", HttpStatus.BAD_REQUEST);
        });
    }
}
