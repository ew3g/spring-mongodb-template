package com.example.springmongodbtemplate.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("items")
public class Item {

    @Id
    public String id;

    public String name;

}
