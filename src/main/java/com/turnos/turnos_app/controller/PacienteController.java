package com.turnos.turnos_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnos.turnos_app.model.Doctor;
import com.turnos.turnos_app.model.Paciente;
import com.turnos.turnos_app.service.PacienteService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    PacienteController(PacienteService ps) {
        this.pacienteService = ps;
    }

    // crear paciente
    @PostMapping
    public Paciente crear(@RequestBody Paciente pt) {
        // ----

        return pacienteService.guardar(pt);
    }

    // listado de pasientes
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    @PostMapping("/anular/{id}")
    public Paciente anular(@RequestBody Long id ) {
        //TODO: process POST request
        
        return pacienteService.anular(id);
    }
            // actualizar doctor
    @PostMapping("/actualiza")
    public Paciente actualizar(@RequestBody Paciente d) {
        // TODO: process POST request e

        return pacienteService.actualizar( d);
    }
    
}
