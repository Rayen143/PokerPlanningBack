package com.example.PokerPlannigProject.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Rayen Benoun
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Developpers")
public class Developper extends User {

    @NonNull//(message = "post cannot be null")
    private Boolean post;


}
