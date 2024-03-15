package com.rafael.demo;

import com.rafael.demo.model.DataSeries;
import com.rafael.demo.service.APIconsumption;
import com.rafael.demo.service.Converter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(new APIconsumption().getData("https://viacep.com.br/ws/08460-367/json/"));
		Converter converter = new Converter();
		DataSeries series =converter.dataConverter(new APIconsumption().getData("https://viacep.com.br/ws/08460-367/json/"), DataSeries.class);
		System.out.println(series);
	}
}
