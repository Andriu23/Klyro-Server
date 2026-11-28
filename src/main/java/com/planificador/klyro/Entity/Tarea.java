package com.planificador.klyro.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(nullable = false, length = 80)
    private String tipo;

    @Column(nullable = false, length = 120)
    private String asignadoA;

    @Column(nullable = false, length = 30)
    private String prioridad;

    @Column(nullable = false, length = 30)
    private String estado;

    @Column(name = "fecha_de_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "fecha_de_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_de_entrega")
    private LocalDate fechaEntrega;

    public Tarea() {
    }

    public Tarea(String nombre, String descripcion, String tipo,
                 String asignadoA, String prioridad, String estado,
                 LocalDate fechaCreacion, LocalDate fechaInicio,
                 LocalDate fechaEntrega) {

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

    public Tarea(Long id, String nombre, String descripcion, String tipo,
                 String asignadoA, String prioridad, String estado,
                 LocalDate fechaCreacion, LocalDate fechaInicio,
                 LocalDate fechaEntrega) {

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
