package com.literalura.catalogoliteralura.services;

import com.literalura.catalogoliteralura.models.Libro;
import com.literalura.catalogoliteralura.repositories.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void guardarLibro(Libro libro) {
        libroRepository.save(libro);
    }

    public void listarLibros() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(libro -> System.out.println(libro.toString()));
    }

    public void buscarLibroPorTitulo(String titulo) {
        List<Libro> libros = libroRepository.findByTituloContaining(titulo);
        libros.forEach(libro -> System.out.println(libro.toString()));
    }
}