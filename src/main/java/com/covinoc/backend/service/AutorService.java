package com.covinoc.backend.service;

import com.covinoc.backend.models.AutorModels;
import com.covinoc.backend.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModels> getAllAutores() {
        return autorRepository.findAll();
    }

    public AutorModels getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public AutorModels createAutor(AutorModels autor) {
        return autorRepository.save(autor);
    }

    public AutorModels updateAutor(Long id, AutorModels autor) {
        AutorModels autorActualizado = autorRepository.findById(id).orElse(null);
        if (autorActualizado != null) {
            autorActualizado.setNombre(autor.getNombre());
            autorActualizado.setApellido(autor.getApellido());
            autorActualizado.setNacionalidad(autor.getNacionalidad());
            return autorRepository.save(autorActualizado);
        } else {
            return null;
        }
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}
