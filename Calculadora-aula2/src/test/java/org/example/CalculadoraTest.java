package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test // indica que um método é um teste
    void somaTest() {
        Calculadora calculadora = new Calculadora(); // cria uma calculadro

        Double resultado = calculadora.soma(10.001,12.2); // faz uma soma

        assertEquals(22.201, resultado); // valida o resultado da soma, valida se a soma é igual a 22.201
        assertNotEquals(0.0,resultado); // valida o resultado da soma
        assertSame(Double.class,resultado.getClass()); // valida o resultado da soma
    }

    @Test // indica que um método é um teste
    void subtrairTest() {
        Calculadora calculadora = new Calculadora(); // cria uma calculadro

        Double resultado = calculadora.subtrai(13.0, 12.0); // faz uma soma

        assertEquals(1.0, resultado); // valida o resultado da soma, valida se a soma é igual a 22.201
        assertNotEquals(0.0,resultado); // valida o resultado da soma
        assertSame(Double.class,resultado.getClass()); // valida o resultado da soma
    }

    dividir(numero1, numero2)
    multplicador(numero1, numero2)
}