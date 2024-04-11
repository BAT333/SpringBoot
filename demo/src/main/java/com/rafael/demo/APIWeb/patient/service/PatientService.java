package com.rafael.demo.APIWeb.patient.service;

import com.rafael.demo.APIWeb.patient.Patient;
import com.rafael.demo.APIWeb.patient.model.DataListPatient;
import com.rafael.demo.APIWeb.patient.model.DataPatient;
import com.rafael.demo.APIWeb.patient.model.DataUpdatePatient;
import com.rafael.demo.APIWeb.patient.repository.RepositoryPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    RepositoryPatient repositoryPatient;

    public void register(DataPatient data) {
        if(this.existsPatient(data.cpf())){
            repositoryPatient.save(new Patient(data));
        }else{
            throw new RuntimeException("PATIENT EXISTS");
        }
    }

    private boolean existsPatient(String cpf) {
        return repositoryPatient.findByCpf(cpf).isEmpty();
    }

    public List<DataListPatient> list() {
        return repositoryPatient.listPatient().stream().map(DataListPatient::new).collect(Collectors.toList());
    }

    public void update(Long id, DataUpdatePatient updatePatient) {
        this.repositoryPatient.findById(id).get().updateDate(updatePatient);

    }

    public void exclusion(Long id) {
        this.repositoryPatient.findById(id).ifPresent(Patient::exclusion);
    }
}
