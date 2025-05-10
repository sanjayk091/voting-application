package com.voting.application.Controller;

import com.voting.application.DTO.CandidateRequestDto;
import com.voting.application.DTO.CandidateResponseDto;
import com.voting.application.Service.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Operation(summary = "Register a new candidate")
    @PostMapping("/register")
    public ResponseEntity<CandidateResponseDto> register(@RequestBody CandidateRequestDto candidateRequest){
        CandidateResponseDto candidateSaved = candidateService.registerCandidate(candidateRequest);
        return ResponseEntity.ok(candidateSaved);
    }
    @Operation(summary = "Get all registered candidates")
    @GetMapping
    public List<CandidateResponseDto> getAll(){
        return candidateService.getAllCandidate();
    }
}
