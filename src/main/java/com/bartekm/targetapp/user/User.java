package com.bartekm.targetapp.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String phoneNumber;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    private String password;

    // both constructors (both all & no args) are made using lombok and annotations

}
