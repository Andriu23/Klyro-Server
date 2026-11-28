package com.planificador.klyro.DTO;

import com.planificador.klyro.Entity.Tarea;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TareaDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;

    @NotBlank(message = "El responsable es obligatorio")
    private String asignadoA;

    @NotBlank(message = "La prioridad es obligatoria")
    private String prioridad;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotNull(message = "La fecha de creación es obligatoria")
    private LocalDate fechaCreacion;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de entrega es obligatoria")
    private LocalDate fechaEntrega;

    public TareaDTO() {
    }

    public TareaDTO(Long id, String nombre, String descripcion,
                    String tipo, String asignadoA, String prioridad,
                    String estado, LocalDate fechaCreacion,
                    LocalDate fechaInicio, LocalDate fechaEntrega) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.asignadoA = asignadoA;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
    }

    public static TareaDTO fromEntity(Tarea tarea) {

        return new TareaDTO(
                tarea.getId(),
                tarea.getNombre(),
                tarea.getDescripcion(),
                tarea.getTipo(),
                tarea.getAsignadoA(),
                tarea.getPrioridad(),
                tarea.getEstado(),
                tarea.getFechaCreacion(),
                tarea.getFechaInicio(),
                tarea.getFechaEntrega()
        );
    }

    public Tarea toEntity() {

        return new Tarea(
                this.nombre,
                this.descripcion,
                this.tipo,
                this.asignadoA,
                this.prioridad,
                this.estado,
                this.fechaCreacion,
                this.fechaInicio,
                this.fechaEntrega
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(String asignadoA) {
        this.asignadoA = asignadoA;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}