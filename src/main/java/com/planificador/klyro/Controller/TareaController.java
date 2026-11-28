package com.planificador.klyro.Controller;

import com.planificador.klyro.DTO.TareaDTO;
import com.planificador.klyro.Entity.Tarea;
import com.planificador.klyro.Service.TareaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public ResponseEntity<List<TareaDTO>> getAllTareas() {
        List<TareaDTO> tareas = tareaService.findAll()
                .stream()
                .map(TareaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TareaDTO> getTareaById(@PathVariable Long id) {
        Tarea tarea = tareaService.findById(id);
        return ResponseEntity.ok(TareaDTO.fromEntity(tarea));
    }


    @PostMapping
    public ResponseEntity<TareaDTO> createTarea(@Valid @RequestBody TareaDTO tareaDTO) {
        Tarea tarea = tareaDTO.toEntity();
        Tarea guardada = tareaService.save(tarea);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TareaDTO.fromEntity(guardada));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TareaDTO> updateTarea(@PathVariable Long id, @Valid @RequestBody TareaDTO tareaDTO) {
        Tarea tarea = tareaDTO.toEntity();
        Tarea actualizada = tareaService.update(id, tarea);
        return ResponseEntity.ok(TareaDTO.fromEntity(actualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        tareaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<TareaDTO>> getByTipo(@PathVariable String tipo) {
        List<TareaDTO> tareas = tareaService.findByTipo(tipo)
                .stream()
                .map(TareaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/asignadoA/{asignadoA}")
    public ResponseEntity<List<TareaDTO>> getByAsignadoA(@PathVariable String asignadoA) {
        List<TareaDTO> tareas = tareaService.findByAsignadoA(asignadoA)
                .stream()
                .map(TareaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(tareas);
    }


    @GetMapping("/prioridad/{prioridad}")
    public ResponseEntity<List<TareaDTO>> getByPrioridad(@PathVariable String prioridad) {
        List<TareaDTO> tareas = tareaService.findByPrioridad(prioridad)
                .stream()
                .map(TareaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<TareaDTO>> getByEstado(@PathVariable String estado) {
        List<TareaDTO> tareas = tareaService.findByEstado(estado)
                .stream()
                .map(TareaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(tareas);
    }
}
