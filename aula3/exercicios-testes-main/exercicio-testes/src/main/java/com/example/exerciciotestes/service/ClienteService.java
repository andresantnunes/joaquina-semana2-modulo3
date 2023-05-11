package com.example.exerciciotestes.service;

import com.example.exerciciotestes.controller.request.ClienteRequest;
import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository ClienteRepository;

    public ClienteService(ClienteRepository ClienteRepository) {
        this.ClienteRepository = ClienteRepository;
    }


    public List<Cliente> buscaTodosClientes(){
        return this.ClienteRepository.findAll();
    }

    public Cliente salvarCliente(ClienteRequest cliente){
        return this.ClienteRepository.save(new Cliente(cliente.getNomeCliente(), cliente.getSaldoCliente()));
    }

    public Cliente atualizarCliente(Long id, ClienteRequest clienteNovo){
        Cliente clienteAtual = buscaClientePorId(id);
        if(clienteAtual == null){
            return null;
        }
        clienteAtual.setNomeCliente(clienteNovo.getNomeCliente());
        clienteAtual.setSaldoCliente(clienteNovo.getSaldoCliente());
        return this.ClienteRepository.save(clienteAtual);
    }

    public Cliente buscaClientePorId (Long id){
        return this.ClienteRepository.findById(id).orElse(null);
    }

    public void detelaClientePorId(Long id){
        if (buscaClientePorId(id) == null){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Cliente não encontrado para o ID "+id);
        }
        this.ClienteRepository.deleteById(id);
    }
}
