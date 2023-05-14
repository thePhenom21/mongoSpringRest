package com.example.mongotest.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@Document(collection = "Todos")
public class Todo {


    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String title;

    private String author;

    private String task;



}
