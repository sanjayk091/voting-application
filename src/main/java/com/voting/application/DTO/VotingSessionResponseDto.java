package com.voting.application.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
public class VotingSessionResponseDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
