package com.example.exerciciotestes.service;

import com.example.exerciciotestes.controller.request.ProdutoRequest;
import com.example.exerciciotestes.model.Produto;
import com.example.exerciciotestes.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository ProdutoRepository;

    public ProdutoService(ProdutoRepository ProdutoRepository) {
        this.ProdutoRepository = ProdutoRepository;
    }


    public List<Produto> buscaTodosProdutos(){
        return this.ProdutoRepository.findAll();
    }

    public Produto salvarProduto( ProdutoRequest produto){
        return this.ProdutoRepository.save(new Produto(produto.getNomeProduto(), produto.getValorProduto()));
    }

    public Produto atualizarProduto(Long id, ProdutoRequest produtoNovo){
        Produto produtoAtual = buscaProdutoPorId(id);
        if(produtoAtual == null){
            return null;
        }
        produtoAtual.setNomeProduto(produtoNovo.getNomeProduto());
        produtoAtual.setValorProduto(produtoNovo.getValorProduto());
        return this.ProdutoRepository.save(produtoAtual);
    }
    public Produto buscaProdutoPorId (Long id){
        return this.ProdutoRepository.findById(id).orElse(null);
    }

    public void detelaProdutoPorId(Long id){
        this.ProdutoRepository.deleteById(id);
    }
}
