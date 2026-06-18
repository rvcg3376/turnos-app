package com.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnos.EstadoRegistro;
import com.turnos.model.Doctor;
import com.turnos.repository.DoctorRepository;

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
