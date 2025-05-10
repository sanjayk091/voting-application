package com.voting.application.Controller;

import com.voting.application.DTO.VoterRequestDto;
import com.voting.application.DTO.VoterResponseDto;
import com.voting.application.Service.VoterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voter")
public class VoterController {

    @Autowired
    private VoterService voterService;
    @Operation(summary = "Register a new voter")
    @PostMapping("/register")
    public ResponseEntity<VoterResponseDto> register(@RequestBody VoterRequestDto voterRequest){
        VoterResponseDto voterResponse = voterService.registerVoter(voterRequest);
        return ResponseEntity.ok(voterResponse);
    }

    @Operation(summary = "Get all registered voters")
    @GetMapping
    public List<VoterResponseDto> getAll(){
        return voterService.getAllVoter();
    }
}
