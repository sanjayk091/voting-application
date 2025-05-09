package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class VoteRequestDto {
    private String voterId;
    private String candidateId;
}
