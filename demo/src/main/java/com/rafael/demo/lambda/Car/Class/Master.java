package com.rafael.demo.lambda.Car.Class;

//https://publicapis.dev/

import com.rafael.demo.lambda.Car.model.Model;
import com.rafael.demo.lambda.Car.model.Models;
import com.rafael.demo.lambda.Car.model.Vehicle;
import com.rafael.demo.lambda.Car.model.Years;
import com.rafael.demo.lambda.Car.service.APIConsumptiom;
import com.rafael.demo.lambda.Car.service.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master {
    private Converter converter = new Converter();
    private APIConsumptiom iconsumption =new APIConsumptiom();
    private Scanner scanner = new Scanner(System.in);

    public void menu(){
        System.out.println(" CARROS \n MOTOS \n CAMINHOES ");
        String type = scanner.next();
        this.type(type).forEach(System.out::println);
        System.out.println("SELECIONE A MARCA");
        String mark = scanner.next();
        this.marks(type,mark);
        System.out.println("SELECIONE A MODELO");
        String model = scanner.next();
        this.models(type,mark,model).forEach(System.out::println);
        List<Vehicle> vehicles = new ArrayList<>();
       for (Years years: this.models(type,mark,model)){
            vehicles.add(this.year(type,mark,model,years.code()));
       }
        vehicles.forEach(System.out::println);
    }

    private Vehicle year(String type, String mark, String model, String year) {
        String json4 = iconsumption.getData("https://parallelum.com.br/fipe/api/v1/"+type.toLowerCase()+"/marcas/"+mark+"/modelos/"+model+"/anos/"+year);
        return converter.converter(json4,Vehicle.class);
    }

    private List<Years> models(String type, String mark, String model) {
        String json3 = iconsumption.getData("https://parallelum.com.br/fipe/api/v1/"+type.toLowerCase()+"/marcas/"+mark+"/modelos/"+model+"/anos");
        return converter.listDate(json3,Years.class);
    }

    private void marks(String type, String mark) {
        String json = iconsumption.getData("https://parallelum.com.br/fipe/api/v1/"+type.toLowerCase()+"/marcas/"+mark+"/modelos");
        converter.converter(json, Models.class).models().forEach(System.out::println);
    }

    private List<Model> type(String type) {
        String json = iconsumption.getData("https://parallelum.com.br/fipe/api/v1/"+type.toLowerCase()+"/marcas");
        return converter.listDate(json, Model.class);

    }

}
