package com.example.ms_intento_libro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;

    @Column(nullable = false, length = 255, name = "titulo_libro")
    private String titulo;

    @Column(nullable = false, length = 150, name = "autor_libro")
    private String autor;

    @Column(length = 150, name = "editorial_libro")
    private String editorial;

    @Column(length = 100, name = "categoria_libro")
    private String categoria;

    @Column(nullable = false, name = "copias_totales_libro")
    private Integer copiasTotales;

    @Column(nullable = false, name = "copias_disponibles_libro")
    private Integer copiasDisponibles;
}
