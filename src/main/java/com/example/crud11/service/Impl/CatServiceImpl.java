package com.example.crud11.service.Impl;

import com.example.crud11.entity.Cat;
import com.example.crud11.payload.CatDto;
import com.example.crud11.repository.CatRepository;
import com.example.crud11.service.CatService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<CatDto> getAllCat(){
        List<Cat> cats = catRepository.findAll();

        return cats.stream().map((cat) -> modelMapper.map(cat, CatDto.class)).collect(Collectors.toList());
    }

    @Override
    public CatDto getCatById(long id){
        Cat cat = catRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(cat, CatDto.class);
    }
}
