package com.planificador.klyro.Repository;

import com.planificador.klyro.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findByTipo(String tipo);

    List<Tarea> findByAsignadoAContainingIgnoreCase(String asignadoA);

    List<Tarea> findByPrioridad(String prioridad);

    List<Tarea> findByEstado(String estado);
}
