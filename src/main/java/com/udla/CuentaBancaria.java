package com.udla;

public class CuentaBancaria {

    private String titular;
    private double saldo;

    // Problema PMD 1: campo privado declarado pero nunca utilizado.
    private String codigoInterno = "SIN-CODIGO";

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        // Problema PMD 2: uso de System.out.println en código de aplicación.
        System.out.println("Depositando: " + monto);

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }

        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }

        if (monto > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        saldo -= monto;

        // Problema PMD 3: bloque catch vacío.
        try {
            Integer.parseInt("ABC");
        } catch (NumberFormatException e) {
        }
    }

    public boolean esMismoTitular(String otroTitular) {
        // Problema PMD 4: comparación incorrecta de String usando ==.
        return titular == otroTitular;
    }

    // Problema PMD 5: método privado declarado pero nunca utilizado.
    private void registrarAuditoriaInterna() {
    }
}