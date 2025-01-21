package com.literalura.catalogoliteralura.services;

import com.literalura.catalogoliteralura.models.Autor;
import com.literalura.catalogoliteralura.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void guardarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(autor -> System.out.println(autor.toString()));
    }

    public void listarAutoresVivos(int año) {
        List<Autor> autores = autorRepository.findByFechaNacimientoBeforeAndFechaFallecimientoAfter(año, año);
        autores.forEach(autor -> System.out.println(autor.toString()));
    }
}