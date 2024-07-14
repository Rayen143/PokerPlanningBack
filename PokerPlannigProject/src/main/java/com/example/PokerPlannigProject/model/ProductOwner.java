package com.example.PokerPlannigProject.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Rayen Benoun
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productowner")
public class ProductOwner extends User{


    @NonNull//(message = "post cannot be null")
    private Boolean post;
}
