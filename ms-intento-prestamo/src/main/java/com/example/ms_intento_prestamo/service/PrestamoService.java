package com.example.ms_intento_prestamo.service;

import com.example.ms_intento_prestamo.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    // Listar todos los préstamos
    List<Prestamo> listarPrestamos();

    // Obtener un préstamo por ID
    Optional<Prestamo> obtenerPrestamoPorId(Long id);

    // Crear un nuevo préstamo (validando reglas)
    Prestamo crearPrestamo(Prestamo prestamo);

    // Actualizar un préstamo existente
    Prestamo actualizarPrestamo(Long id, Prestamo prestamo);

    // Eliminar un préstamo por ID
    void eliminarPrestamo(Long id);

    // Listar préstamos de un usuario
    List<Prestamo> listarPrestamosPorUsuario(Long idUsuario);

    // Contar préstamos activos de un usuario (para validar máximo 3)
    int contarPrestamosActivosPorUsuario(Long idUsuario);

    // Listar préstamos por estado (ACTIVO, DEVUELTO, ATRASADO)
    List<Prestamo> listarPrestamosPorEstado(String estado);

    // Marcar préstamo como devuelto
    Prestamo devolverPrestamo(Long id);
}
