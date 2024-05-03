package com.rafael.demo.APIWeb.Doctor.Controller;

import com.rafael.demo.APIWeb.Doctor.model.DataDoctor;
import com.rafael.demo.APIWeb.Doctor.model.DoctorUpdate;
import com.rafael.demo.APIWeb.Doctor.model.ListDoctor;
import com.rafael.demo.APIWeb.Doctor.service.ServiceDoutor;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("Doctor")
public class DoctorController {
    @Autowired
    ServiceDoutor doutor;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<ListDoctor> registerDoctor(@RequestBody @Valid DataDoctor data, UriComponentsBuilder builder){
      return doutor.register(data,builder);

    }
    @GetMapping("/list")
    public ResponseEntity<Page<ListDoctor>> listDoctor(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return doutor.listDoctor(pageable);

    }
    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<ListDoctor>  update(@PathVariable Long id,@RequestBody @Valid DoctorUpdate update){
        return doutor.updateDoctor(update,id);
    }
    @PutMapping("/exclusion/{id}")
    @Transactional
    public ResponseEntity exclusion(@PathVariable Long id){

        return doutor.exclusionDoctor(id);
    }
}
