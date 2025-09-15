package com.example.ms_intento_libro.service;

import com.example.ms_intento_libro.entity.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    // Listar todos los libros
    List<Libro> listarLibros();

    // Obtener un libro por ID
    Optional<Libro> obtenerLibroPorId(Long id);

    // Guardar un nuevo libro
    Libro guardarLibro(Libro libro);

    // Actualizar un libro existente
    Libro actualizarLibro(Long id, Libro libro);

    // Eliminar un libro por ID
    void eliminarLibro(Long id);

    // Listar libros por categoría
    List<Libro> listarLibrosPorCategoria(String categoria);

    // Listar libros por autor
    List<Libro> listarLibrosPorAutor(String autor);

    // Listar libros por editorial
    List<Libro> listarLibrosPorEditorial(String editorial);

    // Listar solo libros disponibles (copias > 0)
    List<Libro> listarLibrosDisponibles();

    // Verificar si un libro específico tiene copias disponibles
    boolean verificarDisponibilidad(Long id);
}
