package org.avmp.apiexample.repositories;

import org.avmp.apiexample.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
