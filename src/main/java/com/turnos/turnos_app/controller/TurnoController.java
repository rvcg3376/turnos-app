package com.turnos.turnos_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turnos.turnos_app.model.Turno;
import com.turnos.turnos_app.service.TurnoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;
    
    TurnoController(TurnoService tsv){
        this.turnoService = tsv;
    }

    // crear turno
    @PostMapping
    public Turno crear(
@RequestParam Long doctorId,
            @RequestParam Long pacienteId,
            @RequestBody Turno turno
) {
        //TD: process POST request
        
        return turnoService.crearTurno(doctorId, pacienteId,turno);
    }
    
}
