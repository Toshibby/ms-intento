package com.example.ms_intento_prestamo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long id;

    @Column(nullable = false, name = "id_usuario")
    private Long idUsuario; // referencia lógica a ms-usuario

    @Column(nullable = false, name = "id_libro")
    private Long idLibro; // referencia lógica a ms-libro

    @Column(nullable = false, name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @Column(nullable = false, length = 20, name = "estado_prestamo")
    private String estado; // ACTIVO, DEVUELTO, ATRASADO
}
