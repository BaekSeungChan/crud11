package com.example.crud11.controller;

import com.example.crud11.entity.Cat;
import com.example.crud11.payload.CatDto;
import com.example.crud11.service.CatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @PostMapping
    public ResponseEntity<CatDto> createCat(@Valid @RequestBody CatDto catDto){
        CatDto saveCat = catService.createCat(catDto);
        return new ResponseEntity<>(saveCat, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<CatDto>> getAllCat(){
        return ResponseEntity.ok(catService.getAllCat());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(catService.getCatById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCat(@PathVariable(name = "id") long id){
        catService.deleteCat(id);
        return ResponseEntity.ok("delete cat");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatDto> updateCat(@PathVariable(name = "id") long id, @Valid @RequestBody CatDto catDto){
        CatDto saveCat = catService.updateCat(catDto, id);
        return new ResponseEntity<>(saveCat, HttpStatus.OK);
    }
}
