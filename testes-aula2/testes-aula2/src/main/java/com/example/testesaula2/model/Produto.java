package com.example.testesaula2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto") //definindo o nome da coluna no banco de dados
    private String nomeProduto;

    @Column(name = "valor_produto")
    private Double valorProduto;
}