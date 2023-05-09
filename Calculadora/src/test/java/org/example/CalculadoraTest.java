package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void soma() {
        Calculadora calculadora = new Calculadora(); // cria uma calculadro

        double resultado = calculadora.soma(10.0,12.2); // faz uma soma

        assertEquals(22.2, resultado); // valida o resultado da soma
    }
}