package org.avmp.apiexample.services;

import org.avmp.apiexample.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(long id);

    Product save(Product product);

    Optional<Product> update(long id, Product product);

    Optional<Product> deleteById(long id);
}
