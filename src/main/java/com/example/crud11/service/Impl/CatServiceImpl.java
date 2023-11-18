package com.example.crud11.service.Impl;

import com.example.crud11.entity.Cat;
import com.example.crud11.payload.CatDto;
import com.example.crud11.repository.CatRepository;
import com.example.crud11.service.CatService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {
    private final CatRepository catRepository;
    private final ModelMapper modelMapper;

    @Override
    public CatDto createCat(CatDto catDto){
        Cat cat = modelMapper.map(catDto, Cat.class);
        Cat saveCat = catRepository.save(cat);

        return modelMapper.map(saveCat, CatDto.class);

    }

}
