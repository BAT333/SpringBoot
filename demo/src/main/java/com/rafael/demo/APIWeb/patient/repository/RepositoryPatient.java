package com.rafael.demo.APIWeb.patient.repository;

import com.rafael.demo.APIWeb.patient.Patient;
import com.rafael.demo.APIWeb.patient.model.DataListPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryPatient extends JpaRepository<Patient,Long> {
    Optional<Patient> findByCpf(String cpf);

    @Query("SELECT p FROM Patient p ORDER BY p.name")
    List<Patient> listPatient();
    Optional<Patient> findByIdAndActiveTrue(Long id);
}
