package org.sid;

import java.util.Date;
import java.util.Random;

import org.sid.entities.Bill;
import org.sid.entities.ProductItem;
import org.sid.feign.CustomerRestClient;
import org.sid.feign.ProductItemRestClient;
import org.sid.model.Customer;
import org.sid.model.Product;
import org.sid.repository.BillRepository;
import org.sid.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudWsBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudWsBillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BillRepository billRepository, 
			ProductItemRepository productItemRepository,
			CustomerRestClient customerRestClient,
			ProductItemRestClient productItemRestClient
			) {
		
		return args -> {
			Customer customer = customerRestClient.getCustumerById(1L);
			Bill bill1 = billRepository.save(new Bill(null, new Date(), null, null, customer.getId()));
			PagedModel<Product> productPageModel = productItemRestClient.pageProducts();
			productPageModel.forEach(p -> {
				ProductItem productItem = new ProductItem();
				productItem.setPrice(p.getPrice());
				productItem.setQuantity(1 + new Random().nextInt(100));
				productItem.setProductID(p.getId());
				productItem.setBill(bill1);
				productItemRepository.save(productItem);
			});
		};
	}

}
