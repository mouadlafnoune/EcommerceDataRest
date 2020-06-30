package com.mouad2code.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouad2code.ecommerce.dao.ProductRepository;
import com.mouad2code.ecommerce.entity.Product;

@Service
public class ProduitServiceImpl implements ICrudService<Product, Long>{
	
	@Autowired
	ProductRepository produitRepository;

	@Override
	public List<Product> getAll() {
		
		return produitRepository.findAll();
	}

	@Override
	public void add(Product produit) {
		
		produitRepository.save(produit);
	}

	@Override
	public void update(Product produit) {
		
		produitRepository.save(produit);
	}

	@Override
	public void delete(Long id) {
		Product product = new Product();
		product.setId(id);
		produitRepository.delete(product);
	}

	@Override
	public void saveAll(Iterable<Product> iterable) {
		
		produitRepository.saveAll(iterable);
	}

}
