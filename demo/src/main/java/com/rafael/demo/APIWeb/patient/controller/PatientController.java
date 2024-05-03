package com.rafael.demo.APIWeb.patient.controller;

import com.rafael.demo.APIWeb.patient.model.DataListPatient;
import com.rafael.demo.APIWeb.patient.model.DataPatient;
import com.rafael.demo.APIWeb.patient.model.DataUpdatePatient;
import com.rafael.demo.APIWeb.patient.service.PatientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/register")
    @Transactional
    public ResponseEntity<DataListPatient> registerPatient(@RequestBody @Valid DataPatient data, UriComponentsBuilder builder){
        return patientService.register(data, builder);
    }
    @GetMapping("/list")
    public ResponseEntity<Page<DataListPatient>> listPatients (@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){

        return patientService.list(pageable);
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<DataListPatient>  updatePatient(@PathVariable Long id,@RequestBody @Valid DataUpdatePatient updatePatient){
        return patientService.update(id,updatePatient);
    }
    @PutMapping("/exclusion/{id}")
    @Transactional
    public ResponseEntity exclusionPatient(@PathVariable Long id){
        return patientService.exclusion(id);
    }

}
