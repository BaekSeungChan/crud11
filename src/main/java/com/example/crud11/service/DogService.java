package com.example.crud11.service;

import com.example.crud11.entity.Dog;
import com.example.crud11.payload.DogDto;

import java.util.List;

public interface DogService {

    DogDto createDog(DogDto dogDto);

    List<DogDto> getAllDog();

    DogDto getDogById(long id);

    void deleteDog(long id);

    DogDto updateDog(DogDto dogDto, long id);
}
