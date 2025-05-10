package com.voting.application.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "voters", uniqueConstraints ={
        @UniqueConstraint(columnNames = "mobileNumber"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "governmentId")
})
@NoArgsConstructor
public class VoterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @Column(nullable = false, unique = true)
    private String mobileNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String governmentId;

    private Boolean hasVoted = false;
}
