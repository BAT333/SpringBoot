package com.rafael.demo.APIWeb.Doctor.Controller;

import com.rafael.demo.APIWeb.Doctor.model.DataDoctor;
import com.rafael.demo.APIWeb.Doctor.model.DoctorUpdate;
import com.rafael.demo.APIWeb.Doctor.model.ListDoctor;
import com.rafael.demo.APIWeb.Doctor.service.ServiceDoutor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Doctor")
public class DoctorController {
    @Autowired
    ServiceDoutor doutor;

    @PostMapping("/register")
    @Transactional
    public String registerDoctor(@RequestBody DataDoctor data){
      return doutor.register(data);

    }
    @GetMapping("/list")
    public List<ListDoctor> listDoctor(){
        return doutor.listDoctor();

    }
    @PutMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable Long id,@RequestBody DoctorUpdate update){
        doutor.updateDoctor(update,id);
    }
    @PutMapping("/exclusion/{id}")
    @Transactional
    public void exclusion(@PathVariable Long id){
        doutor.exclusionDoctor(id);
    }
}
