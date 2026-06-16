package com.udla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CuentaBancariaTest {

    @Test
    void deberiaCrearCuentaConSaldoInicial() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 500.0);

        assertEquals("Ana Lopez", cuenta.getTitular());
        assertEquals(500.0, cuenta.getSaldo());
    }

    @Test
    void deberiaDepositarMontoPositivo() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 500.0);

        cuenta.depositar(200.0);

        assertEquals(700.0, cuenta.getSaldo());
    }

    @Test
    void deberiaLanzarErrorAlDepositarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 500.0);

        assertThrows(IllegalArgumentException.class, () -> cuenta.depositar(-100.0));
    }

    @Test
    void deberiaRetirarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 500.0);

        cuenta.retirar(200.0);

        assertEquals(300.0, cuenta.getSaldo());
    }

    @Test
    void deberiaLanzarErrorAlRetirarSinSaldoSuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 100.0);

        assertThrows(IllegalStateException.class, () -> cuenta.retirar(500.0));
    }
}