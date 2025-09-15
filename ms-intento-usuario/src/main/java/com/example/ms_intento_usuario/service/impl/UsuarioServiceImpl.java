package com.example.ms_intento_usuario.service.impl;

import com.example.ms_intento_usuario.entity.Usuario;
import com.example.ms_intento_usuario.repository.UsuarioRepository;
import com.example.ms_intento_usuario.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(u -> {
                    u.setNombre(usuario.getNombre());
                    u.setCorreo(usuario.getCorreo());
                    u.setTipo(usuario.getTipo());
                    u.setCarrera(usuario.getCarrera());
                    u.setEstado(usuario.getEstado());
                    return usuarioRepository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public List<Usuario> listarUsuariosPorTipo(String tipo) {
        return usuarioRepository.findByTipo(tipo);
    }

    @Override
    public List<Usuario> listarUsuariosPorEstado(String estado) {
        return usuarioRepository.findByEstado(estado);
    }
}
