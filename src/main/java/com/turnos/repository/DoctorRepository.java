package com.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnos.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
