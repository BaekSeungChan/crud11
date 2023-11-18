package com.example.crud11.service.Impl;

import com.example.crud11.entity.Cat;
import com.example.crud11.entity.Dog;
import com.example.crud11.payload.CatDto;
import com.example.crud11.payload.DogDto;
import com.example.crud11.repository.DogRepository;
import com.example.crud11.service.DogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<DogDto> getAllDog(){
        List<Dog> dogs = dogRepository.findAll();

        return dogs.stream().map((dog) -> modelMapper.map(dog, DogDto.class)).collect(Collectors.toList());
    }

    @Override
    public DogDto getDogById(long id){
        Dog dog = dogRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(dog, DogDto.class);
    }

    @Override
    public void deleteDog(long id){
        Dog dog = dogRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        dogRepository.delete(dog);
    }

    @Override
    public DogDto updateDog(DogDto dogDto, long id){
        Dog dog = dogRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));
        dog.setName(dogDto.getName());
        dog.setAge(dogDto.getAge());

        Dog saveDog = dogRepository.save(dog);

        return modelMapper.map(saveDog, DogDto.class);
    }


}
