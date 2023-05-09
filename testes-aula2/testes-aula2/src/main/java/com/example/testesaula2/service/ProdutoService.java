package com.example.testesaula2.service;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRespository produtoRespository;

    public ProdutoService(ProdutoRespository produtoRespository) {
        this.produtoRespository = produtoRespository;
    }


    public List<Produto> retornaProdutos(){
        return produtoRespository.findAll();
    }

    public Produto salvaProduto(Produto produto){
        return produtoRespository.save(produto);
    }
}
