package com.rafael.demo.APIWeb.appointmentscheduling;

import com.rafael.demo.APIWeb.Doctor.Doctor;
import com.rafael.demo.APIWeb.appointmentscheduling.model.CancelDate;
import com.rafael.demo.APIWeb.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "Consultation")
public class AppointmentScheduling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patients",nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor",nullable = false)
    private Doctor doctor;
    @Column(name = "Consultation",nullable = false)
    private LocalDateTime consultationDate;
    @Column(name = "cancellation")
    private boolean canceled;
    @Column(name = "Reason")
    private String Reason;
    public AppointmentScheduling(){};
    public AppointmentScheduling(Patient patient, Doctor doctor,LocalDateTime localDateTime){
        this.doctor =doctor;
        this.patient =patient;
        this.consultationDate =localDateTime;
        this.canceled = false;
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDateTime consultationDate) {
        this.consultationDate = consultationDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "AppointmentScheduling{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", consultationDate=" + consultationDate +
                '}';
    }

    public void canceling(CancelDate dataConsultation) {
        this.canceled = true;
        this.Reason = dataConsultation.Reason();
    }
}
