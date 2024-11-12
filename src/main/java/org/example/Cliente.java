package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Cliente {
    private String id;
    private double limiteCredito;

    public Cliente(String nome, double limiteCredito) {
        this.id = id;
        this.limiteCredito = limiteCredito;
    }

    public String getNome() {
        return id;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public String toString() {
        return "ID Cliente: " + id + ", Limite de Crédito: " + limiteCredito;
    }
}