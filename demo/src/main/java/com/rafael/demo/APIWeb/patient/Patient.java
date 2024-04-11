package com.rafael.demo.APIWeb.patient;

import com.rafael.demo.APIWeb.Address.Address;
import com.rafael.demo.APIWeb.appointmentscheduling.AppointmentScheduling;
import com.rafael.demo.APIWeb.patient.model.DataPatient;
import com.rafael.demo.APIWeb.patient.model.DataUpdatePatient;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",nullable = false,length = 100)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "telephone",nullable = false,length = 12)
    private String telephone;
    @Column(name = "CPF",nullable = false,length = 20,unique = true)
    private String cpf;
    @Embedded
    @Column(name = "address")
    private Address address;
    @Column(name = "active")
    private boolean active;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<AppointmentScheduling> scheduling;

    public Patient (DataPatient data){

        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.cpf = data.cpf();
        this.address = new Address(data.address());
        this.active = true;

    }
    public Patient(){}
    public Patient (String name, String email, String telephone, String cpf,  Address address){
        this.name =name;
        this.email = email;
        this.telephone = telephone;
        this.cpf = cpf;
        this.address =address;
        this.active = true;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(this == obj)return true;
        if(this.getClass() != obj.getClass())return false;
        Patient patient = (Patient) obj;
        return this.cpf.equals(patient.cpf)&& this.id.equals(patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,cpf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", address=" + address +
                '}';
    }

    public void updateDate(DataUpdatePatient update) {
        if(update.name() != null&& update.name().length()>3){
            this.name = update.name();
        }
        if(update.telephone() != null&& update.telephone().length()>8){
            this.telephone = update.telephone();
        }
        if(update.address()!= null){
            this.address.upadateAddress(update.address());
        }

    }

    public void exclusion() {
        this.active = false;
    }
}
