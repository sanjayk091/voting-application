package com.voting.application.Controller;

import com.voting.application.DTO.VoteRequestDto;
import com.voting.application.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/cast")
    public ResponseEntity<String> cast(@RequestBody VoteRequestDto voteRequestDto){
        voteService.castVote(voteRequestDto);
        return ResponseEntity.ok("Vote cast successfully...");
    }
}
