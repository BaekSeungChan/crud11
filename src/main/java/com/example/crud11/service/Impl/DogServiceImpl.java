package com.example.crud11.service.Impl;

import com.example.crud11.entity.Dog;
import com.example.crud11.payload.DogDto;
import com.example.crud11.repository.DogRepository;
import com.example.crud11.service.DogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final ModelMapper modelMapper;
    private final DogRepository dogRepository;

    @Override
    public DogDto createDog(DogDto dogDto){
        Dog dog = modelMapper.map(dogDto, Dog.class);
        Dog saveDog = dogRepository.save(dog);

        return modelMapper.map(saveDog, DogDto.class);
    }

}
