package com.turnos.turnos_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnos.EstadoRegistro;
import com.turnos.turnos_app.model.Doctor;
import com.turnos.turnos_app.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor guardar(Doctor d){
        d.setEstado(EstadoRegistro.ACTIVO);
        return doctorRepository.save(d);
    }

    public List<Doctor> listar(){
        return doctorRepository.findAll();
    }

    public Doctor anular(Long id){
        Doctor d = doctorRepository.findById(id).orElseThrow();
        d.setEstado(EstadoRegistro.ANULADO);
        return doctorRepository.save(d);
    }

    public Doctor finalizar(Long id){
        Doctor d = doctorRepository.findById(id).orElseThrow();
        d.setEstado(EstadoRegistro.FINALIZADO);
        return doctorRepository.save(d);
    }
}
