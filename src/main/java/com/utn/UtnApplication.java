package com.utn;

import com.utn.models.Categoria;
import com.utn.models.Cliente;
import com.utn.models.Tecnico;
import com.utn.repositories.CategoriaRepo;
import com.utn.repositories.ClienteRepo;
import com.utn.repositories.TecnicoRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UtnApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtnApplication.class, args);
	}
        
       @Bean
       public CommandLineRunner initData(ClienteRepo repoClient, TecnicoRepo repoTec, CategoriaRepo repoCat){
           
           return (args -> {
           
               Cliente cliente1 = new Cliente(31453223, "Juan P", "Los Alamos", "el@gmail.com");
               Cliente cliente2 = new Cliente(31453233, "Robert P", "Los Linos", "al@gmail.com");
               repoClient.save(cliente1);
               repoClient.save(cliente2);
               
               Tecnico tecnico1 = new Tecnico("Alberto", 12324353);
               Tecnico tecnico2 = new Tecnico("Ruperto", 42324353);
               repoTec.save(tecnico1);
               repoTec.save(tecnico2);
               
               Categoria cat1 = new Categoria("Plomeria", "Servicios de Plomeria");
               Categoria cat2 = new Categoria("Gasista", "Servicios");
               Categoria cat3 = new Categoria("Electricista", "Servicios");
               repoCat.save(cat1);
               repoCat.save(cat2);
               repoCat.save(cat3);
               
               tecnico1.addCategoria(cat1);
               tecnico1.addCategoria(cat3);
               tecnico2.addCategoria(cat2);
               repoCat.save(cat1);
               repoCat.save(cat2);
               repoCat.save(cat3);
               repoTec.save(tecnico1);
               repoTec.save(tecnico2);
               
               
           });
       }

}
