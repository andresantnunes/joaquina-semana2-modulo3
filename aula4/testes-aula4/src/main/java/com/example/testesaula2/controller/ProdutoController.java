package com.example.testesaula2.controller;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // localhost:8080/produtos
    // GET, POST, PUT, DELETE -> médotos HTTP
    // GET - Busca dados, com filtro ou não
    @GetMapping
    public List<Produto> retornaProdutos(){ //busca todos os dados de produtos
        return produtoService.retornaProdutos(); // chamando o método retornaProdutos() que retorna uma Lista de Produtos
    }

    // localhost:8080/produtos/1 -> retorna o produto com id = 1
    @GetMapping("/{id}") //busca dados de um unico produto, filtrando por ID
    public Produto retornaProdutoPorId(@PathVariable("id") Long id) throws Exception {
        return produtoService.retornaProdutoPorId(id);
    }

    @PostMapping
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoService.salvaProduto(produto);
    }
}
