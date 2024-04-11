package com.rafael.demo.APIWeb.Doctor;

import com.rafael.demo.APIWeb.Address.Address;
import com.rafael.demo.APIWeb.Doctor.model.DataDoctor;
import com.rafael.demo.APIWeb.Doctor.model.DoctorUpdate;
import com.rafael.demo.APIWeb.Doctor.model.Specialty;
import com.rafael.demo.APIWeb.appointmentscheduling.AppointmentScheduling;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false, length = 100)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "telephone",nullable = false)
    private String telephone;
    @Column(name = "CRM",nullable = false,unique = true)
    private String crm;
    @Enumerated(EnumType.STRING)
    @Column(name = "specialty",nullable = false)
    private Specialty specialty;
    @Embedded
    @Column(name = "address",nullable = false)
    private Address address;
    @Column(name = "active")
    private boolean active;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<AppointmentScheduling> scheduling;
    public Doctor (DataDoctor data){

        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty =data.specialty();
        this.address = new Address(data.address());
        this.active = true;

    }
    public Doctor(){}
    public Doctor (String name,String email, String telephone, String crm, Specialty specialty, Address address){
        this.name =name;
        this.email = email;
        this.telephone = telephone;
        this.crm = crm;
        this.specialty =specialty;
        this.address =address;
        this.active = true;

    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(this == obj)return true;
        if(this.getClass() != obj.getClass())return false;
        Doctor doctor = (Doctor) obj;
        return this.id.equals(doctor.id)&&this.crm.equals(doctor.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,crm);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", crm='" + crm + '\'' +
                ", specialty=" + specialty +
                ", address=" + address +
                ", active=" + active +
                '}';
    }

    public void updateInfos(DoctorUpdate update) {
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
