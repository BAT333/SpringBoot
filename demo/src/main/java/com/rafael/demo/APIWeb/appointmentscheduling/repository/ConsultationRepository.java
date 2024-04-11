package com.rafael.demo.APIWeb.appointmentscheduling.repository;

import com.rafael.demo.APIWeb.Doctor.Doctor;
import com.rafael.demo.APIWeb.appointmentscheduling.AppointmentScheduling;
import com.rafael.demo.APIWeb.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<AppointmentScheduling,Long> {
    Optional<AppointmentScheduling> findByPatientAndConsultationDate(Patient patient,LocalDateTime time);

    Optional<AppointmentScheduling> findByDoctorAndConsultationDateBetween(Doctor doctor, LocalDateTime localDateTime, LocalDateTime localDateTime1);

    Optional<AppointmentScheduling> findByPatientAndConsultationDateAndCanceledFalse(Patient patient, LocalDateTime localDateTime);

    Optional<AppointmentScheduling> findByDoctorAndConsultationDateBetweenAndCanceledFalse(Doctor doctor, LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
