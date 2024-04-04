package com.rafael.demo.persistenciaJava.Class;

import com.rafael.demo.persistenciaJava.model.*;
import com.rafael.demo.persistenciaJava.repository.VehiclesRepository;
import com.rafael.demo.persistenciaJava.service.Converting;
import com.rafael.demo.persistenciaJava.service.SearchingAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master {
    private final SearchingAPI  api = new SearchingAPI();
    private final Converting converting = new Converting();
    private final Scanner key = new Scanner(System.in);
    private VehiclesRepository repository;

    public Master(VehiclesRepository repository) {
        this.repository = repository;
    }


    public void menu(){
        int num = -1;
        while (num !=0){
            System.out.println("""
                    1- PESQUISA DE TABELA DE CARRO
                    2- COMPRA VEICULO
                    3- SAIR\s""");
            int nums = key.nextInt();
            switch (nums){
                case 1:
                   // this.search().stream().map(Vehicles::new).forEach(v->repository.save(v));
                    this.repository.findAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("NUMERO 2");
                    break;
                case 3:
                    num = 0;
                    break;
            }


        }

    }

    private List<Vehicle> search() {
        System.out.println("""
                    1- CARRO
                    2- MOTO
                    3- CAMINHOES\s""");
        int nums = key.nextInt();
        String type = switch (nums) {
            case 1 -> {
                System.out.println("CARROS");
                yield "carros";
            }
            case 2 -> {
                System.out.println("MOTO");
                yield "motos";
            }
            case 3 -> {
                System.out.println("CAMINHOES");
                yield "caminhoes";
            }
            default -> null;
        };
        return this.mark(type);
    }

    private List<Vehicle> mark(String type) {
        converting.convertingListAPI(api.getDate("https://parallelum.com.br/fipe/api/v1/"+type+"/marcas"), Model.class).forEach(System.out::println);
        System.out.println("DIGITE CODIGO DA PESQUISA");
        String num = key.next();
        api.getDate("https://parallelum.com.br/fipe/api/v1/"+type+"/marcas/"+num+"/modelos");
        return this.models(num,type);
    }

    private List<Vehicle> models(String num, String type) {
        converting.convertingAPI(api.getDate("https://parallelum.com.br/fipe/api/v1/"+type+"/marcas/"+num+"/modelos"), Models.class).models().forEach(System.out::println);
        System.out.println("DIGITE CODIGO DA PESQUISA");
        String model = key.next();
        return this.vehicle(num,type,model);
    }
    private Vehicle year(String type, String mark, String model, String year) {
        String json4 = api.getDate("https://parallelum.com.br/fipe/api/v1/"+type.toLowerCase()+"/marcas/"+mark+"/modelos/"+model+"/anos/"+year);
        return converting.convertingAPI(json4,Vehicle.class);
    }

    private List<Vehicle> vehicle(String num, String type, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        List<Years>  years  = converting.convertingListAPI(api.getDate("https://parallelum.com.br/fipe/api/v1/"+type.toLowerCase()+"/marcas/"+num+"/modelos/"+model+"/anos"), Years.class);
        for (Years year: years){
            vehicles.add( this.year(type,num,model,year.code()));
        }
        return vehicles;
    }
}
