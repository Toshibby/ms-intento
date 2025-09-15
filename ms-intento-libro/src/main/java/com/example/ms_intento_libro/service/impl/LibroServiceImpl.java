package com.example.ms_intento_libro.service.impl;

import com.example.ms_intento_libro.entity.Libro;
import com.example.ms_intento_libro.repository.LibroRepository;
import com.example.ms_intento_libro.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        return libroRepository.findById(id)
                .map(l -> {
                    l.setTitulo(libro.getTitulo());
                    l.setAutor(libro.getAutor());
                    l.setEditorial(libro.getEditorial());
                    l.setCategoria(libro.getCategoria());
                    l.setCopiasTotales(libro.getCopiasTotales());
                    l.setCopiasDisponibles(libro.getCopiasDisponibles());
                    return libroRepository.save(l);
                })
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public List<Libro> listarLibrosPorCategoria(String categoria) {
        return libroRepository.findByCategoria(categoria);
    }

    @Override
    public List<Libro> listarLibrosPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    @Override
    public List<Libro> listarLibrosPorEditorial(String editorial) {
        return libroRepository.findByEditorial(editorial);
    }

    @Override
    public List<Libro> listarLibrosDisponibles() {
        return libroRepository.findByCopiasDisponiblesGreaterThan(0);
    }

    @Override
    public boolean verificarDisponibilidad(Long id) {
        return !libroRepository.findByIdAndCopiasDisponiblesGreaterThan(id, 0).isEmpty();
    }
}
