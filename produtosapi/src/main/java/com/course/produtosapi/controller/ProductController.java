package com.course.produtosapi.controller;

import com.course.produtosapi.model.Product;
import com.course.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProdutoRepository produtoRepository;

    public ProductController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        System.out.println("Produto recebido: " + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        produtoRepository.save(product);
        return product;
    }
}
