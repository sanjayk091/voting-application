package com.voting.application.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
public class VotingSessionRequestDto {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
