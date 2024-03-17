package com.rafael.demo;

import com.rafael.demo.Class.Master;
import com.rafael.demo.model.DataComplementary;
import com.rafael.demo.model.DataSeries;
import com.rafael.demo.model.DataInformation;
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

		Master master = new Master();
		master.menu();
	}
}
