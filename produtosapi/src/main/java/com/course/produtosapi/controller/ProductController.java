package com.course.produtosapi.controller;

import com.course.produtosapi.model.Product;
import com.course.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("{id}")
    public Product obterPorId(@PathVariable("id") String id){
//        Optional<Product> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;

        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                            @RequestBody Product produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Product> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByName(nome);
    }
}
