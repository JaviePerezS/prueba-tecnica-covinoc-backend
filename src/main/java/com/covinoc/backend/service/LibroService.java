package com.covinoc.backend.service;

import com.covinoc.backend.models.LibroModels;
import com.covinoc.backend.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<LibroModels> getAllLibros() {
        return libroRepository.findAll();
    }

    public LibroModels getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public LibroModels createLibro(LibroModels libro) {
        return libroRepository.save(libro);
    }

    public LibroModels updateLibro(Long id, LibroModels libro) {
        LibroModels libroActualizado = libroRepository.findById(id).orElse(null);
        if (libroActualizado != null) {
            libroActualizado.setTitulo(libro.getTitulo());
            libroActualizado.setDescripcion(libro.getDescripcion());
            libroActualizado.setFechaPublicacion(libro.getFechaPublicacion());
            libroActualizado.setPaginas(libro.getPaginas());
            libroActualizado.setIdioma(libro.getIdioma());
            libroActualizado.setAutor(libro.getAutor());
            return libroRepository.save(libroActualizado);
        } else {
            return null;
        }
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
