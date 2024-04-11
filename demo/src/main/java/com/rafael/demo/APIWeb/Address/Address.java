package com.rafael.demo.APIWeb.Address;

import com.rafael.demo.APIWeb.Address.model.DataAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "number",length = 5)
    private String number;
    @Column(name = "complement")
    private String complement;
    @Column(name = "neighborhood",nullable = false)
    private String neighborhood;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "uf",nullable = false,length = 3)
    private String uf;
    @Column(name = "zipCode",nullable = false)
    private String zipCode;
    public Address(){}
    public Address(DataAddress address){
        this.street = address.street();
        this.number = address.number();
        this.complement = address.complement();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.uf = address.uf();
        this.zipCode= address.zipCode();

    }
    public Address(String street,String number, String complement, String neighborhood, String city , String uf , String zipCode){
        this.street =street;
        this.number = number;
        this.complement =complement;
        this.neighborhood =neighborhood;
        this.city = city;
        this.uf =uf;
        this.zipCode= zipCode;



    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public String getComplement(){
        return complement;
    }
    public void setComplement(String complement){
        this.complement = complement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", uf='" + uf + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public void upadateAddress(DataAddress address) {
        if(address.city() !=null){
            this.city =address.city();

        }
        if(address.complement() !=null){
            this.complement = address.complement();

        }
        if(address.neighborhood() !=null){
            this.neighborhood = address.neighborhood();

        }
        if(address.uf() !=null){
            this.uf =address.uf();

        }
        if(address.number() !=null){
            this.number =address.number();

        }
        if(address.zipCode() !=null){
            this.zipCode = address.zipCode();

        }
        if(address.street() !=null){
            this.street =address.street();

        }

    }
}
