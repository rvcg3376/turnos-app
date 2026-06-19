package com.turnos.turnos_app.model;

import java.time.LocalDateTime;

import com.turnos.EstadoRegistro;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turnos", schema = "autoriza")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHora;

    // ACTIVO, ANULADO, FINALIZADO
    private EstadoRegistro estado;

    // Relación MANY-TO-ONE con Paciente
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    // Relación MANY-TO-ONE con Doctor

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;

}
