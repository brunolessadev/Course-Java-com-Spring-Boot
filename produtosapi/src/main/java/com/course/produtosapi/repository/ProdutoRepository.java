package com.course.produtosapi.repository;

import com.course.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Product, String> {

    List<Product> findByName(String name);
}
