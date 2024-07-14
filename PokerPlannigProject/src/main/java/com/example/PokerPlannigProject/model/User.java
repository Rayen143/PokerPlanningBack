package com.example.PokerPlannigProject.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
/**
 * Rayen Benoun
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="users")
public class User {
    @Id
    private String id;
    @NonNull//(message = "name cannot be null")
    private String name;
    @NonNull//(message = "email cannot be null")
    private String email;
    @NonNull//(message = "password cannot be null")
    private String password;


    private Date createdAt;
    private Date updatedAt;
}
