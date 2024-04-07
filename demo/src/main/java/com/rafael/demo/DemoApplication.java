package com.rafael.demo;


import com.rafael.demo.persistenciaJava.Class.Master;
import com.rafael.demo.persistenciaJava.repository.ProjectRepository;
import com.rafael.demo.persistenciaJava.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ProjectRepository repository;
	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Master master = new Master(repository,taskRepository);
		master.menu();
        /*  Master master = new Master();
        master.menu();

		Master master = new Master();
		master.menu();



        Map<String,String>map = new LinkedHashMap<>();
        map.put("RAFAEL","alves");
        map.put("JANAINA","alves");
        map.put("ARMENIO","alves");
        map.put("RENAN","alves");
        map.put("RIAN","alves");
        //{RIAN=alves, RAFAEL=alves, JANAINA=alves, ARMENIO=alves, RENAN=alves}
        System.out.println(map);
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());

        }


        APIConsumptiom apiConsumptiom = new APIConsumptiom();
        Converter converter = new Converter();
        System.out.println(apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos"));
        String json3 = apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos");

        System.out.println(converter.listDate(json3,Years.class));
        for (Years years:converter.listDate(json3,Years.class)){
            System.out.println(years.code());

        }

         */


/*
		System.out.println(apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos"));
		String json2 = apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos");

		Models modelo = converter.converter(json2, Models.class);
		System.out.println(modelo);
		modelo.modelos().forEach(System.out::println);
		modelo.anos().forEach(System.out::println);



		System.out.println(apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos"));
		String json3 = apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos");
		List<Anos> anos = new ArrayList<>();
		List asnos = converter.converter(json3,anos.getClass());
		System.out.println(asnos);


		System.out.println(apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3"));
		String json4 = apiConsumptiom.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3");
		Veiculo veiculo = converter.converter(json4,Veiculo.class);
		System.out.println(veiculo);

 */




	}
}
