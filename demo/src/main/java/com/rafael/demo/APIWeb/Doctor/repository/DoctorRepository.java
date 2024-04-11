package com.rafael.demo.APIWeb.Doctor.repository;

import com.rafael.demo.APIWeb.Doctor.Doctor;
import com.rafael.demo.APIWeb.Doctor.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Optional<Doctor> findByCrm(String crm);
    @Query(value = "select d from Doctor d order by d.name desc")
    List<Doctor> listDoctors();

    List<Doctor> findALLBySpecialtyAndActiveTrue(Specialty specialty);
}
