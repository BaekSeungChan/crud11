package com.example.crud11.payload;

import lombok.Data;

@Data
public class DogDto {
    private Long id;
    private String name;
    private Integer age;

    private Long catId;

}
