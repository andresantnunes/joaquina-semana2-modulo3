package com.example.exerciciotestes.service;

import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //Ativa as anotações do mockito
class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    void buscaTodosClientes() {
        List<Cliente> listaCliente = List.of(new Cliente(1L,"Cliente",10.0));
        when(clienteRepository.findAll()).thenReturn(listaCliente);

        List<Cliente> listaClienteResultado = clienteService.buscaTodosClientes();

        assertNotNull(listaClienteResultado);
        assertEquals(listaCliente.get(0).getNomeCliente(), listaClienteResultado.get(0).getNomeCliente());
        verify(clienteRepository).findAll();
    }

    @Test
    void buscaClientePorId() {
    }

    @Test
    void salvarCliente() {
    }

    @Test
    void atualizarCliente() {
    }



    @Test
    void detelaClientePorId() {
    }
}