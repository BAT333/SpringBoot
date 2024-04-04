package com.rafael.demo.persistenciaJava.repository;

import com.rafael.demo.persistenciaJava.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
}
