package com.example.crud11.service;

import com.example.crud11.payload.CatDto;

import java.util.List;

public interface CatService {

    CatDto createCat(CatDto catDto);

    List<CatDto> getAllCat();

    CatDto getCatById(long id);

    void deleteCat(long id);

    CatDto updateCat(CatDto catDto, long id);

}
