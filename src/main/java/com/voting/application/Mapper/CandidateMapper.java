package com.voting.application.Mapper;

import com.voting.application.DTO.CandidateRequestDto;
import com.voting.application.DTO.CandidateResponseDto;
import com.voting.application.DTO.VoterRequestDto;
import com.voting.application.DTO.VoterResponseDto;
import com.voting.application.Entity.CandidateEntity;
import com.voting.application.Entity.VoterEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateMapper {
    public static CandidateEntity toEntity(CandidateRequestDto candidateRequestDto){
        CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setName(candidateRequestDto.getName());
        candidateEntity.setPartyName(candidateRequestDto.getPartyName());
        return candidateEntity;
    }

    public static CandidateResponseDto toDto(CandidateEntity candidateEntity){
        CandidateResponseDto candidateResponseDto = new CandidateResponseDto();
        candidateResponseDto.setId(candidateEntity.getId());
        candidateResponseDto.setName(candidateEntity.getName());
        candidateResponseDto.setPartyName(candidateEntity.getPartyName());
        return candidateResponseDto;
    }

    public static List<CandidateResponseDto> toDto(List<CandidateEntity> voterEntity){
        return voterEntity.stream()
                .map(CandidateMapper::toDto)
                .collect(Collectors.toList());
    }
}
