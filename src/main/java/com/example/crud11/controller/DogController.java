package com.example.crud11.controller;

import com.example.crud11.payload.DogDto;
import com.example.crud11.service.DogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dog")
@RequiredArgsConstructor
@Tag(name = "Dog API's")
public class DogController {
    private final DogService dogService;

    @PostMapping
    @Operation(
            summary = "Create Dog",
            description = "Create Dog API"
    )
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable(name = "id") long id){
        dogService.deleteDog(id);
        return ResponseEntity.ok("delete Dog");
    }

    @PutMapping("/{id}")
    public  ResponseEntity<DogDto> updateDog(@PathVariable(name = "id") long id, @Valid @RequestBody DogDto dogDto){
        DogDto saveDog = dogService.updateDog(dogDto, id);
        return new ResponseEntity<>(saveDog, HttpStatus.OK);
    }
}
