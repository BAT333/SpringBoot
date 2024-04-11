package com.rafael.demo.APIWeb.appointmentscheduling.controller;

import com.rafael.demo.APIWeb.appointmentscheduling.model.CancelDate;
import com.rafael.demo.APIWeb.appointmentscheduling.model.DataConsultation;
import com.rafael.demo.APIWeb.appointmentscheduling.service.ConsultationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scheduling")
public class ConsultationContoller {
    @Autowired
    ConsultationService consultationService;
    @PostMapping("{id}")
    @Transactional
    public void scheduling(@PathVariable Long id, @RequestBody DataConsultation dataConsultation){
        this.consultationService.consultationRegistration(id,dataConsultation);

    }
    @PutMapping("{id}")
    public void canceling(@PathVariable Long id, @RequestBody CancelDate dataConsultation){
        this.consultationService.cancelingTheAppointment(id,dataConsultation);

    }
}
