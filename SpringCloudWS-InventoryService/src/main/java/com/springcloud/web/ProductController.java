package com.springcloud.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.dao.ProduitRepository;
import com.springcloud.entities.Product;

@RestController
public class ProductController {

	@Autowired
	private ProduitRepository produitRepository;
	
	@GetMapping(path = "/produits")
	public List<Product> list(){
		return produitRepository.findAll();
	}
	
	@GetMapping(path = "/produits/{id}")
	public Product getOne(@PathVariable Long id) {
		return produitRepository.findById(id).get();
	}
	
	@PostMapping(path = "/produits")
	public Product save(@RequestBody Product produit) {
		return produitRepository.save(produit);
	}
	
	@PutMapping(path = "/produits/{id}")
	public Product update(@PathVariable Long id, @RequestBody Product produit) {
		produit.setId(id);
		return produitRepository.save(produit);
	}
	
	@DeleteMapping(path = "/produits/{id}")
	public void delete(@PathVariable Long id) {
		produitRepository.deleteById(id);
	}
}
