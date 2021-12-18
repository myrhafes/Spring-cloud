package org.sid;

import org.sid.entities.Customer;
import org.sid.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class SpringCloudWsCostumerServiceApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWsCostumerServiceApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
		restConfiguration.exposeIdsFor(Customer.class);
		
		customerRepository.save(new Customer(null,"med","@gmail.com"));
		customerRepository.save(new Customer(null,"med","@gmail.com"));
		customerRepository.save(new Customer(null,"med","@gmail.com"));
		
		customerRepository.findAll().forEach(c -> {
			System.out.println(c.toString());
		});
	}

}
