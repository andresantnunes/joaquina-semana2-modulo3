package com.example.testesaula2.service;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Habilita o Mockito na classe ProdutoServiceTest
class ProdutoServiceTest {

    @Mock // ele permite a criação de respostas falsas do produto respository
    private ProdutoRepository produtoRepository;

    @InjectMocks // indica que o produtoService vai receber as respostas falsas do Produto Repository
    private ProdutoService produtoService;

    @Test
    void retornaProdutosTest() {
        List<Produto> produtosMock = List.of(
                new Produto(1L,"nome", 10.0)
        ); // lista de produtos

        // Força quem sempre que eu chamar o produtoRepository.findAll eu vou retornar uma lista de produtos
        // no caso a lista é o produtosMock
        when(produtoRepository.findAll()).thenReturn(produtosMock);

        List<Produto> produtosResposta = produtoService.retornaProdutos();

        assertEquals(produtosMock.get(0).getNomeProduto(), produtosResposta.get(0).getNomeProduto());
        verify(produtoRepository).findAll();// validar se o método findAll foi executado uma vez
    }

    @Test
    void salvaProdutoTest() {
    }
}