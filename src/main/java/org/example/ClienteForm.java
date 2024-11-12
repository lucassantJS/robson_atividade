package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteForm extends JFrame {
    private JTextField nomeField;
    private JButton updateButton;

    public ClienteForm() {
        setTitle("Atualização de Cliente");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        JLabel nomeLabel = new JLabel("Limite do cliente:");
        nomeField = new JTextField();

        updateButton = new JButton("Update");

        add(nomeLabel);
        add(nomeField);
        add(new JLabel()); // Espaço vazio
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();

                // Simulação de operação de atualização
                JOptionPane.showMessageDialog(null, "Dados atualizados para o cliente ID: " + nome);
            }
        });
    }
}
