package com.example.exerciciotestes.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class VendaServiceTest {

    @Mock
    ProdutoService produtoService;
    @Mock
    ClienteService clienteService;

    @InjectMocks
    VendaService vendaService;

    @Test
    void buscaTodosVendas() {
    }

    @Test
    void realizarVenda() {
    }

    @Test
    void buscaVendaPorId() {
    }
}