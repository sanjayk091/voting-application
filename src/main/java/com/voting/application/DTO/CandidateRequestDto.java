package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CandidateRequestDto {
    private String name;
    private String partyName;
}
