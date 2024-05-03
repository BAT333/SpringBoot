package com.rafael.demo.APIWeb.patient.service;

import com.rafael.demo.APIWeb.patient.Patient;
import com.rafael.demo.APIWeb.patient.model.DataListPatient;
import com.rafael.demo.APIWeb.patient.model.DataPatient;
import com.rafael.demo.APIWeb.patient.model.DataUpdatePatient;
import com.rafael.demo.APIWeb.patient.repository.RepositoryPatient;
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
public class PatientService {
    @Autowired
    RepositoryPatient repositoryPatient;

    public ResponseEntity<DataListPatient> register(DataPatient data, UriComponentsBuilder builder) {
        if(this.existsPatient(data.cpf())){
           Patient patient = repositoryPatient.save(new Patient(data));
            URI uri = builder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
           return ResponseEntity.created(uri).body(new DataListPatient(patient));
        }else{
            throw new RuntimeException("PATIENT EXISTS");
        }
    }

    private boolean existsPatient(String cpf) {
        return repositoryPatient.findByCpf(cpf).isEmpty();
    }

    public ResponseEntity<Page<DataListPatient>> list(Pageable pageable) {
        return ResponseEntity.ok(repositoryPatient.findAll(pageable).map(DataListPatient::new));
    }

    public ResponseEntity<DataListPatient> update(Long id, DataUpdatePatient updatePatient) {
        Patient patient = repositoryPatient.findById(id).get();
        patient.updateDate(updatePatient);
        return ResponseEntity.ok(new DataListPatient(patient));

    }

    public ResponseEntity exclusion(Long id) {
        this.repositoryPatient.findById(id).ifPresent(Patient::exclusion);
        return ResponseEntity.noContent().build();
    }
}
