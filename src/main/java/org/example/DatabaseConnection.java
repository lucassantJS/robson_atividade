package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Substitua "meu_banco" pelo nome do banco de dados que você criou no pgAdmin
    private static final String URL = "jdbc:postgresql://localhost:5432/atividade-robson";
    private static final String USER = "postgres"; // Substitua pelo seu usuário do PostgreSQL
    private static final String PASSWORD = "root"; // Substitua pela sua senha do PostgreSQL

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem-sucedida com o banco de dados PostgreSQL.");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }
}
