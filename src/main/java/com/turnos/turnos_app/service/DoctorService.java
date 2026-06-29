package com.turnos.turnos_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turnos.EstadoRegistro;
import com.turnos.turnos_app.model.Doctor;
import com.turnos.turnos_app.repository.DoctorRepository;

import jakarta.transaction.Transactional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    public Doctor guardar(Doctor d){
        d.setEstado(EstadoRegistro.ACTIVO);
        return doctorRepository.save(d);
    }

    public List<Doctor> listar(){
        return doctorRepository.findAll();
    }

    @Transactional
    public Doctor anular(Long id){
        Doctor d = doctorRepository.findById(id).orElseThrow();
        d.setEstado(EstadoRegistro.ANULADO);
        return doctorRepository.save(d);
    }

    @Transactional
    public Doctor actualizar( Doctor d){
        Doctor dx = doctorRepository.findById(d.getId()).orElseThrow();
        dx.setNombre(d.getNombre());
        dx.setIdentificacion(d.getIdentificacion());
        return doctorRepository.save(dx);
    }

}
