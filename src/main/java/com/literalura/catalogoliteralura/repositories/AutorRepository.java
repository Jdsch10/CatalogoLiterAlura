package com.literalura.catalogoliteralura.repositories;

import com.literalura.catalogoliteralura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByFechaNacimientoBeforeAndFechaFallecimientoAfter(int fechaNacimiento, int fechaFallecimiento);
}