package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class VotingResultDto {
    private Long candidateId;
    private String name;
    private String partyName;
    private Long totalVotes;

    public VotingResultDto(Long candidateId, String name, String partyName, Long totalVotes) {
        this.candidateId = candidateId;
        this.name = name;
        this.partyName = partyName;
        this.totalVotes = totalVotes;
    }
}
