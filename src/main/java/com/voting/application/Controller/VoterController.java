package com.voting.application.Controller;

import com.voting.application.DTO.VoterRequestDto;
import com.voting.application.DTO.VoterResponseDto;
import com.voting.application.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voter")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<VoterResponseDto> register(@RequestBody VoterRequestDto voterRequest){
        VoterResponseDto voterResponse = voterService.registerVoter(voterRequest);
        return ResponseEntity.ok(voterResponse);
    }

    @GetMapping
    public List<VoterResponseDto> getAll(){
        return voterService.getAllVoter();
    }
}
