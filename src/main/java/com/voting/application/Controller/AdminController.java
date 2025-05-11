package com.voting.application.Controller;

import com.voting.application.DTO.VotingResultDto;
import com.voting.application.DTO.VotingSessionRequestDto;
import com.voting.application.DTO.VotingSessionResponseDto;
import com.voting.application.Service.AdminService;
import com.voting.application.Service.VotingSessionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private VotingSessionService votingSessionService;
    @Operation(summary = "Get voting result")
    @GetMapping("/result")
    public ResponseEntity<List<VotingResultDto>> getResult() {
        List<VotingResultDto> votingResultList = adminService.getLiveResults();
        return ResponseEntity.ok(votingResultList);
    }

    @Operation(summary = "Start a new voting session")
    @PostMapping("/voting-session/start")
    private ResponseEntity<VotingSessionResponseDto> startSession(@RequestBody VotingSessionRequestDto votingSessionDto){
        VotingSessionResponseDto votingSession = votingSessionService.startSession(votingSessionDto);
        return ResponseEntity.ok(votingSession);
    }

    @Operation(summary = "End an ongoing voting session by ID")
    @PostMapping("/voting-session/end")
    public ResponseEntity<String> endSession() {
        votingSessionService.endSession();
        return ResponseEntity.ok("Voting Session Closed. ");
    }

}
