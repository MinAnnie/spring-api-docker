package org.avmp.apiexample.services;

import org.avmp.apiexample.entities.Product;
import org.avmp.apiexample.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product ProductDb = productOptional.orElseThrow();
            ProductDb.setName(product.getName());
            ProductDb.setDescription(product.getDescription());
            return Optional.of(productRepository.save(ProductDb));
        }
        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> deleteById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        productOptional.ifPresent(product ->
                productRepository.delete(product));

        return productOptional;
    }
}
