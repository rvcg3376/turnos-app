package com.turnos.turnos_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnos.turnos_app.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
