package com.voting.application.Mapper;

import com.voting.application.DTO.VotingSessionRequestDto;
import com.voting.application.DTO.VotingSessionResponseDto;
import com.voting.application.Entity.VotingSessionEntity;

public class VotingSessionMapper {
    public static VotingSessionEntity toEntity(VotingSessionRequestDto votingSessionDto){
        VotingSessionEntity votingSession = new VotingSessionEntity();
        votingSession.setActive(true);
        votingSession.setStartTime(votingSessionDto.getStartTime());
        votingSession.setEndTime(votingSessionDto.getEndTime());
        return votingSession;
    }

    public static VotingSessionResponseDto toDto(VotingSessionEntity votingSessionEntity) {
        VotingSessionResponseDto votingSessionResponseDto = new VotingSessionResponseDto();
        votingSessionResponseDto.setId(votingSessionEntity.getId());
        votingSessionResponseDto.setStartTime(votingSessionEntity.getStartTime());
        votingSessionResponseDto.setEndTime(votingSessionEntity.getEndTime());
        return votingSessionResponseDto;
    }
}
