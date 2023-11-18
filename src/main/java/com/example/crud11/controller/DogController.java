package com.example.crud11.controller;

import com.example.crud11.payload.DogDto;
import com.example.crud11.service.DogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/all")
    public ResponseEntity<List<DogDto>> getAllDog(){
        return ResponseEntity.ok(dogService.getAllDog());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogDto> getDogById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(dogService.getDogById(id));
    }
}
