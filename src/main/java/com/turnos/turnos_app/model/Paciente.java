package com.turnos.turnos_app.model;

import java.time.LocalDateTime;

import com.turnos.EstadoRegistro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paciente" , schema = "autoriza")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String identificacion;
    @Column(insertable = false, updatable = false)
    private LocalDateTime fechaIngreso;
    // ACTIVO, ANULADO, FINALIZADO
    private EstadoRegistro estado;
} 
