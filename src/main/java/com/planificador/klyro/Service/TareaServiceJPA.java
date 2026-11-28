package com.planificador.klyro.Service;

import com.planificador.klyro.Entity.Tarea;
import com.planificador.klyro.Repository.TareaRepository;
import com.planificador.klyro.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TareaServiceJPA implements TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaServiceJPA(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tarea findById(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea update(Long id, Tarea tareaActualizada) {
        Tarea existente = tareaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con ID: " + id));

        existente.setNombre(tareaActualizada.getNombre());
        existente.setDescripcion(tareaActualizada.getDescripcion());
        existente.setTipo(tareaActualizada.getTipo());
        existente.setAsignadoA(tareaActualizada.getAsignadoA());
        existente.setPrioridad(tareaActualizada.getPrioridad());
        existente.setEstado(tareaActualizada.getEstado());
        existente.setFechaCreacion(tareaActualizada.getFechaCreacion());
        existente.setFechaInicio(tareaActualizada.getFechaInicio());
        existente.setFechaEntrega(tareaActualizada.getFechaEntrega());

        return tareaRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tarea no encontrada con ID: " + id);
        }
        tareaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findByTipo(String tipo) {
        return tareaRepository.findByTipo(tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findByAsignadoA(String asignadoA) {
        return tareaRepository.findByAsignadoAContainingIgnoreCase(asignadoA);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findByPrioridad(String prioridad) {
        return tareaRepository.findByPrioridad(prioridad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> findByEstado(String estado) {
        return tareaRepository.findByEstado(estado);
    }
}