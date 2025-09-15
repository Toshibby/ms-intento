package com.example.ms_intento_libro.repository;

import com.example.ms_intento_libro.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar libros por categoría
    List<Libro> findByCategoria(String categoria);

    // Buscar libros por autor
    List<Libro> findByAutor(String autor);

    // Buscar libros por editorial
    List<Libro> findByEditorial(String editorial);

    // Buscar solo libros disponibles (copias > 0)
    List<Libro> findByCopiasDisponiblesGreaterThan(int cantidad);

    // Buscar libro específico que tenga copias disponibles
    List<Libro> findByIdAndCopiasDisponiblesGreaterThan(Long id, int cantidad);
}
