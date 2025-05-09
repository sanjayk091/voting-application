package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class VoterRequestDto {
    private String name;
    private String mobileNumber;
    private Boolean hasVoted = false;
}
