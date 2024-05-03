package com.rafael.demo.APIWeb.Doctor.service;

import com.rafael.demo.APIWeb.Doctor.Doctor;
import com.rafael.demo.APIWeb.Doctor.model.DataDoctor;
import com.rafael.demo.APIWeb.Doctor.model.DoctorUpdate;
import com.rafael.demo.APIWeb.Doctor.model.ListDoctor;
import com.rafael.demo.APIWeb.Doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceDoutor {
    @Autowired
    DoctorRepository doctorRepository;


    public ResponseEntity<ListDoctor> register(DataDoctor data, UriComponentsBuilder builder) {
        if(this.doctorExists(data.crm())){
            Doctor doctor = doctorRepository.save(new Doctor(data));
            URI uri = builder.path("/Doctor/{id}").buildAndExpand(doctor.getId()).toUri();
            return ResponseEntity.created(uri).body(new ListDoctor(doctor));
        }else {
            throw new RuntimeException("DOCTOR EXISTS");
        }
    }

    private boolean doctorExists(String crm) {
        if(doctorRepository.findByCrm(crm).isEmpty()){
            return true;
        }else {
            throw new RuntimeException("DOCTOR EXISTS");

        }
    }

    public ResponseEntity<Page<ListDoctor>> listDoctor(Pageable pageable) {
        //return doctorRepository.findAll().stream().map(ListDoctor::new).collect(Collectors.toList());
        return ResponseEntity.ok(doctorRepository.findAll(pageable).map(ListDoctor::new));
    }

    public ResponseEntity<ListDoctor>  updateDoctor(DoctorUpdate update,Long id) {
        Doctor doctor = doctorRepository.findById(id).get();
        doctor.updateInfos(update);
        return ResponseEntity.ok(new ListDoctor(doctor));
    }

    public ResponseEntity exclusionDoctor(Long id) {
        //   doctorRepository.findByCrm(crm).ifPresent(Doctor::active);
        doctorRepository.findById(id).ifPresent(Doctor::exclusion);
        return ResponseEntity.noContent().build();
    }
}
