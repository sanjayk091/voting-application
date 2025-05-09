package com.voting.application.Mapper;

import com.voting.application.DTO.VoterRequestDto;
import com.voting.application.DTO.VoterResponseDto;
import com.voting.application.Entity.VoterEntity;

import java.util.List;
import java.util.stream.Collectors;

public class VoterMapper {

    public static VoterEntity toEntity(VoterRequestDto voterRequestDto){
        VoterEntity voterEntity = new VoterEntity();
        voterEntity.setName(voterRequestDto.getName());
        voterEntity.setMobileNumber(voterRequestDto.getMobileNumber());
        voterEntity.setHasVoted(voterRequestDto.getHasVoted());
        return voterEntity;
    }

    public static VoterResponseDto toDto(VoterEntity voterEntity){
        VoterResponseDto voterResponseDto = new VoterResponseDto();
        voterResponseDto.setId(voterEntity.getId());
        voterResponseDto.setName(voterEntity.getName());
        voterResponseDto.setMobileNumber(voterEntity.getMobileNumber());
        voterResponseDto.setHasVoted(voterEntity.getHasVoted());
        return voterResponseDto;
    }

    public static List<VoterResponseDto> toDto(List<VoterEntity> voterEntity){
        return voterEntity.stream()
                .map(VoterMapper::toDto)
                .collect(Collectors.toList());
    }
}
