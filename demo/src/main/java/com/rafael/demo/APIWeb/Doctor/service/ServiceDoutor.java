package com.rafael.demo.APIWeb.Doctor.service;

import com.rafael.demo.APIWeb.Doctor.model.DoctorUpdate;
import com.rafael.demo.APIWeb.Doctor.model.ListDoctor;
import com.rafael.demo.APIWeb.Doctor.Doctor;
import com.rafael.demo.APIWeb.Doctor.model.DataDoctor;
import com.rafael.demo.APIWeb.Doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceDoutor {
    @Autowired
    DoctorRepository doctorRepository;


    public String register(DataDoctor data) {
        if(this.doctorExists(data.crm())){
            doctorRepository.save(new Doctor(data));
            return "REGISTER";
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

    public List<ListDoctor> listDoctor() {
       //return doctorRepository.findAll().stream().map(ListDoctor::new).collect(Collectors.toList());
        return doctorRepository.listDoctors().stream().map(ListDoctor::new).collect(Collectors.toList());
    }

    public void updateDoctor(DoctorUpdate update,Long id) {
        doctorRepository.findById(id).get().updateInfos(update);
    }

    public void exclusionDoctor(Long id) {
    //   doctorRepository.findByCrm(crm).ifPresent(Doctor::active);
        doctorRepository.findById(id).ifPresent(Doctor::exclusion);
    }
}
