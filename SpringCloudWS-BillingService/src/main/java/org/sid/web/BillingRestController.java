package org.sid.web;

import java.util.Collection;

import org.sid.entities.Bill;
import org.sid.feign.CustomerRestClient;
import org.sid.feign.ProductItemRestClient;
import org.sid.model.Customer;
import org.sid.model.Product;
import org.sid.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private CustomerRestClient customerRestClient;
	
	@Autowired
	private ProductItemRestClient productItemRestClient;
	
	@GetMapping(path = "bill/full/{id}")
	public Bill getBill(@PathVariable Long id) {
		Bill bill = billRepository.findById(id).get();
		Customer customer = customerRestClient.getCustumerById(bill.getCustomerId());
		bill.setCustomer(customer);
		bill.getProductItems().forEach(pi -> {
			Product product = productItemRestClient.getProductById(pi.getProductID());
			pi.setProduct(product);
		});
		return bill;
	}
}
