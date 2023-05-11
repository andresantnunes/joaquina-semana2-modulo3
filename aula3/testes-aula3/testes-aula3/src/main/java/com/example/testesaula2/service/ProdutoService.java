package com.example.testesaula2.service;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ClienteService clienteService;

    public ProdutoService(ProdutoRepository produtoRepository, ClienteService clienteService) {
        this.produtoRepository = produtoRepository;
        this.clienteService = clienteService;
    }


    public List<Produto> retornaProdutos(){
        System.out.println("Retornando Produtos");
        List<Produto> listaProduto = produtoRepository.findAll();

        System.out.println(clienteService.retornaCliente());

        return listaProduto;
    }

    public Produto salvaProduto(Produto produto){
        return produtoRepository.save(produto);
    }
}
