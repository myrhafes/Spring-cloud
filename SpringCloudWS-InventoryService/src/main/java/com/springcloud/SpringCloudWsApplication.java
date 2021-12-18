package com.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.springcloud.dao.ProduitRepository;
import com.springcloud.entities.Product;

@SpringBootApplication
public class SpringCloudWsApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		restConfiguration.exposeIdsFor(Product.class);
		
		produitRepository.save(new Product(null, "HP G5", 6000, 3));
		produitRepository.save(new Product(null, "DELL", 6000, 3));
		produitRepository.save(new Product(null, "SAMSUNG A5", 6000, 3));
		produitRepository.save(new Product(null, "IPHONE X", 6000, 3));
		
		produitRepository.findAll().forEach(p -> {
			System.out.println(p.getName());
		});
	}

}
