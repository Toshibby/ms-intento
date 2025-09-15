package com.example.ms_intento_usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false, length = 100, name = "nombre_usuario")
    private String nombre;

    @Column(nullable = false, unique = true, length = 150, name = "correo_usuario")
    private String correo;

    @Column(nullable = false, length = 20, name = "tipo_usuario")
    private String tipo; // ALUMNO o DOCENTE

    @Column(length = 100, name = "carrera_usuario")
    private String carrera;

    @Column(nullable = false, length = 20, name = "estado_usuario")
    private String estado; // ACTIVO o INACTIVO
}
