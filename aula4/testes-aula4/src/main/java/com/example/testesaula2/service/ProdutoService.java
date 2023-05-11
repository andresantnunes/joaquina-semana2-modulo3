package com.example.testesaula2.service;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public List<Produto> retornaProdutos(){
        return produtoRepository.findAll();
    }

    public Produto salvaProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto retornaProdutoPorId(Long id) throws Exception {
        return produtoRepository.findById(id).orElseThrow(Exception::new);
    }
}
