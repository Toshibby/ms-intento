package com.example.ms_intento_usuario.repository;

import com.example.ms_intento_usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por correo (único)
    Optional<Usuario> findByCorreo(String correo);

    // Listar usuarios por tipo (ALUMNO o DOCENTE)
    List<Usuario> findByTipo(String tipo);

    // Listar usuarios por estado (ACTIVO o INACTIVO)
    List<Usuario> findByEstado(String estado);

    // Verificar si un usuario está activo
    Optional<Usuario> findByIdAndEstado(Long id, String estado);
}
