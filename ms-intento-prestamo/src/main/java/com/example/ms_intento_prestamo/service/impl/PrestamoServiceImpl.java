package com.example.ms_intento_prestamo.service.impl;

import com.example.ms_intento_prestamo.entity.Prestamo;
import com.example.ms_intento_prestamo.repository.PrestamoRepository;
import com.example.ms_intento_prestamo.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Optional<Prestamo> obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id);
    }

    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo prestamo) {
        return prestamoRepository.findById(id)
                .map(p -> {
                    p.setIdUsuario(prestamo.getIdUsuario());
                    p.setIdLibro(prestamo.getIdLibro());
                    p.setFechaPrestamo(prestamo.getFechaPrestamo());
                    p.setFechaDevolucion(prestamo.getFechaDevolucion());
                    p.setEstado(prestamo.getEstado());
                    return prestamoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }

    @Override
    public void eliminarPrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public List<Prestamo> listarPrestamosPorUsuario(Long idUsuario) {
        return prestamoRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public int contarPrestamosActivosPorUsuario(Long idUsuario) {
        return prestamoRepository.countByIdUsuarioAndEstado(idUsuario, "ACTIVO");
    }

    @Override
    public List<Prestamo> listarPrestamosPorEstado(String estado) {
        return prestamoRepository.findByEstado(estado);
    }

    @Override
    public Prestamo devolverPrestamo(Long id) {
        return prestamoRepository.findById(id)
                .map(p -> {
                    p.setEstado("DEVUELTO");
                    return prestamoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }
}
