package com.covinoc.backend.controller;

import com.covinoc.backend.models.AutorModels;
import com.covinoc.backend.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModels>> getAllAutores() {
        return new ResponseEntity<>(autorService.getAllAutores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModels> getAutorById(@PathVariable Long id) {
        AutorModels autor = autorService.getAutorById(id);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AutorModels> createAutor(@RequestBody AutorModels autor) {
        AutorModels nuevoAutor = autorService.createAutor(autor);
        return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorModels> updateAutor(@PathVariable Long id, @RequestBody AutorModels autor) {
        AutorModels autorActualizado = autorService.updateAutor(id, autor);
        if (autorActualizado != null) {
            return new ResponseEntity<>(autorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
