package com.rafael.demo.APIWeb.patient.controller;

import com.rafael.demo.APIWeb.patient.model.DataListPatient;
import com.rafael.demo.APIWeb.patient.model.DataPatient;
import com.rafael.demo.APIWeb.patient.model.DataUpdatePatient;
import com.rafael.demo.APIWeb.patient.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/register")
    @Transactional
    public void registerPatient(@RequestBody DataPatient data){
        patientService.register(data);
    }
    @GetMapping("/list")
    public List<DataListPatient> listPatients (){
       return patientService.list();
    }

    @PutMapping("/update/{id}")
    @Transactional
    public void updatePatient(@PathVariable Long id,@RequestBody DataUpdatePatient updatePatient){
        this.patientService.update(id,updatePatient);
    }
    @PutMapping("/exclusion/{id}")
    @Transactional
    public void exclusionPatient(@PathVariable Long id){
        this.patientService.exclusion(id);
    }

}
