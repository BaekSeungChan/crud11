package com.example.crud11.controller;

import com.example.crud11.payload.DogDto;
import com.example.crud11.service.DogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dog")
@RequiredArgsConstructor
public class DogController {
    private final DogService dogService;

    @PostMapping
    public ResponseEntity<DogDto> createDog(@Valid @RequestBody DogDto dogDto){
        DogDto saveResponse = dogService.createDog(dogDto);
        return new ResponseEntity<>(saveResponse, HttpStatus.OK);
    }
}
