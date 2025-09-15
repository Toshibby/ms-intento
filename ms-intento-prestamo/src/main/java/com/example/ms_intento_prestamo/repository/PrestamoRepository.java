package com.example.ms_intento_prestamo.repository;

import com.example.ms_intento_prestamo.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // Listar préstamos de un usuario
    List<Prestamo> findByIdUsuario(Long idUsuario);

    // Contar préstamos activos de un usuario (para validar máximo 3)
    int countByIdUsuarioAndEstado(Long idUsuario, String estado);

    // Listar préstamos por estado
    List<Prestamo> findByEstado(String estado);

    // Buscar préstamos activos de un usuario
    List<Prestamo> findByIdUsuarioAndEstado(Long idUsuario, String estado);
}
