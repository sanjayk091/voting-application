package com.voting.application.Service;

import com.voting.application.DTO.VoterRequestDto;
import com.voting.application.DTO.VoterResponseDto;
import com.voting.application.Entity.VoterEntity;
import com.voting.application.Exception.VotingException;
import com.voting.application.Mapper.VoterMapper;
import com.voting.application.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;
    public VoterResponseDto registerVoter(VoterRequestDto voterRequest) {

        if(voterRepository.existsByMobileNumber(voterRequest.getMobileNumber())){
            throw new VotingException("Voter with this mobile number already exists", HttpStatus.CONFLICT);
        }

        if(voterRepository.existsByEmail(voterRequest.getEmail())){
            throw new VotingException("Email already registered", HttpStatus.CONFLICT);
        }

        if(voterRepository.existsByGovernmentId(voterRequest.getGovernmentId())){
            throw new VotingException("Government ID already registered", HttpStatus.CONFLICT);
        }

        VoterEntity voterEntity = VoterMapper.toEntity(voterRequest);
        VoterEntity voterSaved = voterRepository.save(voterEntity);
        return VoterMapper.toDto(voterSaved);
    }

    public List<VoterResponseDto> getAllVoter() {
        List<VoterEntity> voterEntity = voterRepository.findAll();
        return VoterMapper.toDto(voterEntity);
    }
}
