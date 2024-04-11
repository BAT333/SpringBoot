package com.rafael.demo.APIWeb.appointmentscheduling.service;

import com.rafael.demo.APIWeb.Doctor.Doctor;
import com.rafael.demo.APIWeb.Doctor.model.Specialty;
import com.rafael.demo.APIWeb.Doctor.repository.DoctorRepository;
import com.rafael.demo.APIWeb.appointmentscheduling.AppointmentScheduling;
import com.rafael.demo.APIWeb.appointmentscheduling.model.CancelDate;
import com.rafael.demo.APIWeb.appointmentscheduling.model.DataConsultation;
import com.rafael.demo.APIWeb.appointmentscheduling.repository.ConsultationRepository;
import com.rafael.demo.APIWeb.patient.Patient;
import com.rafael.demo.APIWeb.patient.repository.RepositoryPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ConsultationService {
    @Autowired
    RepositoryPatient patient;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    ConsultationRepository consultationRepository;
    private final  LocalTime OPENINGTIME = LocalTime.of(7,0);
    private final  LocalTime CLOSINGTIMES = LocalTime.of(19,0);
    private final LocalDateTime MINUTESBEFORE = LocalDateTime.now().plusMinutes(30);

    private boolean validatedDate(LocalDateTime time){
        if(MINUTESBEFORE.isBefore(time)){
            if( CLOSINGTIMES.isBefore(time.toLocalTime())||OPENINGTIME.isAfter(time.toLocalTime())||time.getDayOfWeek().equals("SUNDAY")){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
    private Patient patientSearch(Long id,LocalDateTime localDateTime){
        Optional<Patient> patient1 = patient.findByIdAndActiveTrue(id);
        if(patient1.isPresent()){
            if(this.consultationRepository.findByPatientAndConsultationDateAndCanceledFalse(patient1.get(),localDateTime).isPresent()){
                throw new RuntimeException("Patient already has an appointment today");

            }else{
                return patient1.get();
            }


        }else{
            throw new RuntimeException("PATIENT DOES NOT EXIST");
        }
    }
    private Doctor douctorSearch(Specialty specialty,LocalDateTime localDateTime){
        List<Doctor> doctors = this.doctorRepository.findALLBySpecialtyAndActiveTrue(specialty);
        ThreadLocalRandom random =ThreadLocalRandom.current();
        int i = random.nextInt(doctors.size());
       if(this.consultationRepository.findByDoctorAndConsultationDateBetweenAndCanceledFalse(doctors.get(i),localDateTime,localDateTime.plusHours(1).plusMinutes(10)).isEmpty()){
           return doctors.get(i);
       }else{
           throw new RuntimeException("DOCTOR ALREADY HAS AN APPOINTMENT AT THIS TIME");
       }

    }


    public void consultationRegistration(Long id, DataConsultation dataConsultation) {
        if(this.validatedDate(dataConsultation.localDateTime())){
            throw new RuntimeException("No opening hours");
        }else {
           this.consultationRepository.save(new AppointmentScheduling(this.patientSearch(id,dataConsultation.localDateTime()),this.douctorSearch(dataConsultation.specialist(),dataConsultation.localDateTime()),dataConsultation.localDateTime()));
        }
    }

    public void cancelingTheAppointment(Long id, CancelDate dataConsultation) {
        this.consultationRepository.findById(id).ifPresent(c->c.canceling(dataConsultation));
    }
}
