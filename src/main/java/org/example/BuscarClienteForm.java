package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarClienteForm extends JFrame {
    private JTextField idField;
    private JButton buscarButton;

    public BuscarClienteForm() {
        setTitle("Buscar Cliente");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        JLabel idLabel = new JLabel("ID do Cliente:");
        idField = new JTextField();

        buscarButton = new JButton("Buscar");

        add(idLabel);
        add(idField);
        add(new JLabel()); // Espaço vazio
        add(buscarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idField.getText();

                // Validação para garantir que o ID é um número inteiro
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int id = Integer.parseInt(idText);
                        buscarClientePorId(id);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor, insira um ID numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void buscarClientePorId(int id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT cliente, limite FROM clientes_limites WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nomeCliente = rs.getString("cliente");
                double limiteCredito = rs.getDouble("limite");
                JOptionPane.showMessageDialog(null, "Cliente: " + nomeCliente + "\nLimite de crédito: R$ " + limiteCredito);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente com ID " + id + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
