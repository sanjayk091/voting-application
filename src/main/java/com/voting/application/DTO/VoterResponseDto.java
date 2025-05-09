package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
public class VoterResponseDto {
    private Long id;
    private String name;
    private String mobileNumber;
    private Boolean hasVoted = false;
}
