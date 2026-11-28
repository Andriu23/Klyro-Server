package com.planificador.klyro.Service;

import com.planificador.klyro.Entity.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> findAll();
    Tarea findById(Long id);
    Tarea save(Tarea tarea);
    Tarea update(Long id, Tarea tarea);
    void deleteById(Long id);
    List<Tarea> findByTipo(String tipo);
    List<Tarea> findByAsignadoA(String asignadoA);
    List<Tarea> findByPrioridad(String prioridad);
    List<Tarea> findByEstado(String estado);
}
