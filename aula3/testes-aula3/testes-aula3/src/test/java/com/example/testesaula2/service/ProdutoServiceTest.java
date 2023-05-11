package com.example.testesaula2.service;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import com.example.testesaula2.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Habilita o Mockito na classe ProdutoServiceTest
class ProdutoServiceTest {

    @Mock // ele permite a criação de respostas falsas do produto respository
    private ProdutoRepository produtoRepository;

    @Mock // ele permite a criação de respostas falsas do produto respository
    private ClienteService clienteService;

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
        when(clienteService.retornaCliente()).thenReturn("Cliente mock");


        List<Produto> produtosResposta = produtoService.retornaProdutos();

        assertEquals(produtosMock.get(0).getNomeProduto(), produtosResposta.get(0).getNomeProduto());
        verify(produtoRepository).findAll();// validar se o método findAll foi executado uma vez
        //eu gostaria de saber se o testes que eu fiz usou o mock que eu criei
    }

    @Test
    void salvaProdutoTest() {
        // Mockito normal

        //Given -> Dado um mock
        Produto produtoMock  = new Produto(1L,"nome", 10.0);
        when(produtoRepository.save(any())).thenReturn(produtoMock);

        //When -> Quando executo um código
        Produto produtoResposta = produtoService.salvaProduto(produtoMock);

        //Then -> Então tenho o resultado
        assertEquals(produtoMock.getNomeProduto(), produtoResposta.getNomeProduto());
        verify(produtoRepository).save(any());

    }

    @Test
    void salvaProdutoTestBDD() {
        //Mockito BDD

        //Given - BDD
        // Preparação do Teste
        // Dado a execução de produtoRepository eu vou retornar o produtoMock
        Produto produtoMock  = new Produto(1L,"nome", 10.0);
        given(produtoRepository.save(any())).willReturn(produtoMock);

        //When - BDD
        // Execução do Teste
        // Quando eu executar o salvaProduto utilizo o mock acima
        Produto produtoResposta = produtoService.salvaProduto(produtoMock);

        //Then
        // Validações do Teste do Mockito
        // Então valido se o save() foi chamado, se o objeto foi salvo
        then(produtoRepository).should().save(any());

        // JUnit
        // Valida se produtoResposta não é nulo
        assertNotNull(produtoResposta);

        // Valida se 2 valores são identicos
        assertEquals(produtoMock.getNomeProduto(), produtoResposta.getNomeProduto());

    }
}