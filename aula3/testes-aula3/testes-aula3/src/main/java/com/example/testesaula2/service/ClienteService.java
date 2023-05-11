package com.example.testesaula2.service;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    public String retornaCliente(){
        return "cliente";
    }
}
