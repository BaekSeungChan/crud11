package com.example.crud11.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CatDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "2 over charater")
    private String name;
    private Integer age;
}
