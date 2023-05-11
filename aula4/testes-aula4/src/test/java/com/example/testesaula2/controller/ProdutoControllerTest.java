package com.example.testesaula2.controller;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // gera mocks dentro do Spring Boot Test
            // diferente do @Mock
    ProdutoRepository produtoRepository; //permite gerar respostas falsas do produto repository durante a execução do teste


    @Test // teste de Integração
    // integra o lado de fora da nossa aplicação com o que está dentro
    void testRetornaProdutos() throws Exception {
        mockMvc.perform(  // executa uma requisição
                MockMvcRequestBuilders                      //cria uma requisição
                        .get("/produtos")         // chama o endpoint /produtos com um GET
                        .accept(MediaType.APPLICATION_JSON) // eu espero como resposta um JSON
                )
                .andExpect(    //validação do resultado da chamada
                        MockMvcResultMatchers // é o resultado da chamada realizada dentro do perform
                                .status().isOk() // validação se o status da resposta é OK (200)
                        )
                .andExpect( // validação do resultado da chamada
                        MockMvcResultMatchers
                                .content().json(
                                        """
                                                  []
                                                  """
                                )); // valida se o conteúdo é um json

    }

    @Test
    void testRetornaProdutoPorId() throws Exception {

        Produto produto = new Produto(1L,"Produto",10.0);// é o resultado da chamada ao banco de dados

        // sempre que o findById for chamado o resultado será um Optional de produto
        when(produtoRepository.findById(anyLong())).thenReturn(Optional.of(produto));

        mockMvc.perform(  // executa uma requisição
                        MockMvcRequestBuilders                      //cria uma requisição
                                .get("/produtos/1")         // chama o endpoint /produtos/1 com um GET
                                .accept(MediaType.APPLICATION_JSON) // eu espero como resposta um JSON
                )
                .andExpect(    //validação do resultado da chamada
                        MockMvcResultMatchers // é o resultado da chamada realizada dentro do perform
                                .status().isOk() // validação se o status da resposta é OK (200)
                )
                .andExpect( // validação do resultado da chamada
                        MockMvcResultMatchers
                                .content().json(
                                        """
                                                  {
                                                        "id": 1,
                                                        "nomeProduto": "Produto",
                                                        "valorProduto": 10.0
                                                  }
                                                  """
                                )); // valida se o conteúdo é um json

    }

    @Test
    void testSalvaProduto() {
    }
}