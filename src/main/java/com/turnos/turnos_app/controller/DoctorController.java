package com.turnos.turnos_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnos.turnos_app.model.Doctor;
import com.turnos.turnos_app.service.DoctorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/doctores")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // crear doctor
    @PostMapping
    public Doctor crear(@RequestBody Doctor entity) {
        // TODO: process POST request e

        return doctorService.guardar(entity);
    }

    // Listar Dcotores
    @GetMapping
    public List<Doctor> listar() {
        return doctorService.listar();
    }

    // anular doctor
    @PostMapping("/anular/{id}")
    public Doctor anular(@RequestBody Long id) {
        // TODO: process POST request

        return doctorService.anular(id);
    }

    @PutMapping("/finalizar/{id}")
    public Doctor finalizar(@PathVariable Long id) {
        return doctorService.finalizar(id);
    }

}
