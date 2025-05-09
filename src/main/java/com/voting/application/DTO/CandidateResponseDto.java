package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CandidateResponseDto {
    private Long id;
    private String name;
    private String partyName;
}
