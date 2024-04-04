package com.rafael.demo.persistenciaJava.model;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;

import java.math.BigDecimal;
@Table(name = "vehicle")
@Entity
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "vehicleType")
    private VehicleType vehicleType;
    @Column(name = "velues")
    private BigDecimal velues;
    @Column(name = "mark",length = 50)
    private  String mark;
    @Column(name = "model")
    private  String model;
    @Column(name = "yearmodel",length = 20)
    private   String yearModel;
    @Column(name = "fuel")
    @Enumerated(EnumType.STRING)
    private  Fuel fuel;
    @Column(name = "codefipe",length = 50)
    private  String codeFipe;
    @Column(name = "referencemonth",length = 30)
    private  String referenceMonth;
    @Enumerated(EnumType.STRING)
    private  FuelAcronyms acronymFuel;

    public Vehicles (Vehicle vehicle){
        this.vehicleType =VehicleType.Type(Integer.parseInt(vehicle.vehicleType()));
        this.velues = BigDecimal.valueOf(Long.parseLong(vehicle.velues().replaceAll("[^0-9]+","")));
        this.mark = vehicle.mark();
        this.fuel = Fuel.valueOf(vehicle.fuel().toUpperCase());
        this.codeFipe = vehicle.codeFipe();
        this.referenceMonth = vehicle.referenceMonth();
        this.acronymFuel = FuelAcronyms.valueOf(vehicle.acronymFuel());
        this.model = vehicle.model();
        this.yearModel = vehicle.yearModel();
    }
    public Long getId(){
        return id;
    }
    public BigDecimal getVelues(){
        return this.velues;
    }
    public void setVelues(BigDecimal velues){
        this.velues = velues;
    }
    public Vehicles(){}

    @Override
    public String toString() {
        return "Vehicles{" +
                "vehicleType=" + vehicleType +
                ", velues=" + velues +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", yearModel='" + yearModel + '\'' +
                ", fuel=" + fuel +
                ", codeFipe='" + codeFipe + '\'' +
                ", referenceMonth='" + referenceMonth + '\'' +
                ", acronymFuel=" + acronymFuel +
                '}';
    }


}
