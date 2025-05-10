package com.voting.application.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CandidateRequestDto {

    @NotBlank(message = "Candidate name is required.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Party name is required.")
    @Size(min = 2, max = 50, message = "Party Name must be between 2 and 50 characters")
    private String partyName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Constituency is required")
    private String constituency;

    @NotNull(message = "Age is required")
    @Min(value = 25, message = "Candidate must be at least 25 years old")
    private Integer age;
}
