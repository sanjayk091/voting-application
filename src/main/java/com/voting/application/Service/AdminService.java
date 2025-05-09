package com.voting.application.Service;

import com.voting.application.Entity.VoteEntity;
import com.voting.application.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private VoteRepository voteRepository;
    public Map<String, Long> getLiveResults() {
        return voteRepository.findAll().stream()
                .collect(Collectors.groupingBy(v -> v.getCandidate().getName(), Collectors.counting()));
    }

}
