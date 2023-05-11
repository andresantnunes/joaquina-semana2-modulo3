package com.example.testesaula2.controller;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> retornaProdutos(){
        return produtoService.retornaProdutos();
    }

    @PostMapping
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoService.salvaProduto(produto);
    }
}
