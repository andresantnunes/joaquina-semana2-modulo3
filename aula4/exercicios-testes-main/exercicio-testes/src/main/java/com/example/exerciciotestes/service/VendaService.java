package com.example.exerciciotestes.service;

import com.example.exerciciotestes.controller.request.VendaRequest;
import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.model.Produto;
import com.example.exerciciotestes.model.Venda;
import com.example.exerciciotestes.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ClienteService clienteService; // utilizar no exercicio 9
    private final ProdutoService produtoService; // utilizar no exercicio 9

    public VendaService(VendaRepository VendaRepository, ClienteService clienteService, ProdutoService produtoService) {
        this.vendaRepository = VendaRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }


    public List<Venda> buscaTodosVendas(){
        return this.vendaRepository.findAll();
    }

    public Venda realizarVenda(VendaRequest vendaRequest){
        Cliente cliente = clienteService.buscaClientePorId(vendaRequest.getClienteId());

        List<Produto> produtos = new ArrayList<>();
        // para cada item da lista do vendaRequest.getProdutos()
        // eu vou salvar o item na variavel idProduto
        for(Long idProduto: vendaRequest.getProdutos()) {
            produtos.add(produtoService.buscaProdutoPorId(idProduto));
        }

        // todo save faz o retorno dos dados que salvou
        return vendaRepository.save(new Venda(vendaRequest.getValorVenda(),cliente,produtos));

        // TODO: código a ser feito no método TDD
    }

    public Venda buscaVendaPorId (Long id){
        return this.vendaRepository.findById(id).orElse(null);
    }

}
