package com.covinoc.backend.controller;

import com.covinoc.backend.models.LibroModels;
import com.covinoc.backend.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroModels>> getAllLibros() {
        return new ResponseEntity<>(libroService.getAllLibros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroModels> getLibroById(@PathVariable Long id) {
        LibroModels libro = libroService.getLibroById(id);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LibroModels> createLibro(@RequestBody LibroModels libro) {
        LibroModels nuevoLibro = libroService.createLibro(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroModels> updateLibro(@PathVariable Long id, @RequestBody LibroModels libro) {
        LibroModels libroActualizado = libroService.updateLibro(id, libro);
        if (libroActualizado != null) {
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
