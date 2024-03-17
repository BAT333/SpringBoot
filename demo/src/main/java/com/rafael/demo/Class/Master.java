package com.rafael.demo.Class;

import com.rafael.demo.model.DataComplementary;
import com.rafael.demo.model.DataInformation;
import com.rafael.demo.model.DataSeries;
import com.rafael.demo.service.APIconsumption;
import com.rafael.demo.service.Converter;

import java.util.Scanner;

public class Master {
    private Converter converter = new Converter();
    private APIconsumption iconsumption =new APIconsumption();
    private Scanner scanner = new Scanner(System.in);

    public void menu(){
        System.out.println("DIGITE SEU CEP");
        String cep =  scanner.next();
        String json = iconsumption.getData("https://viacep.com.br/ws/08460-367/json/");
        DataSeries series =converter.dataConverter(json, DataSeries.class);
        DataInformation information = converter.dataConverter(json, DataInformation.class);
        DataComplementary complementary =  converter.dataConverter(json, DataComplementary.class);
        System.out.println(series);
        System.out.println(information);
        System.out.println(complementary);

    }

}
