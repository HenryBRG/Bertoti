/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.simpleia;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class SimpleIA {
    public static void main(String[] args) {
        String schemaDefinition = "CREATE TABLE IF NOT EXISTS Alunos (\n" +
                "    id INT PRIMARY KEY,\n" +
                "    nome VARCHAR(100),\n" +
                "    idade INT\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS Cursos (\n" +
                "    id INT PRIMARY KEY,\n" +
                "    nome VARCHAR(100),\n" +
                "    duracao INT\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS Matriculas (\n" +
                "    aluno_id INT,\n" +
                "    curso_id INT,\n" +
                "    data_matricula DATE,\n" +
                "    PRIMARY KEY (aluno_id, curso_id),\n" +
                "    FOREIGN KEY (aluno_id) REFERENCES Alunos(id),\n" +
                "    FOREIGN KEY (curso_id) REFERENCES Cursos(id)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS Professores (\n" +
                "    id INT PRIMARY KEY,\n" +
                "    nome VARCHAR(100)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS CursoProfessores (\n" +
                "    curso_id INT,\n" +
                "    professor_id INT,\n" +
                "    PRIMARY KEY (curso_id, professor_id),\n" +
                "    FOREIGN KEY (curso_id) REFERENCES Cursos(id),\n" +
                "    FOREIGN KEY (professor_id) REFERENCES Professores(id)\n" +
                ");\n" +
                "CREATE TABLE IF NOT EXISTS AlunosCursos (\n" +
                "    aluno_id INT,\n" +
                "    curso_id INT,\n" +
                "    PRIMARY KEY (aluno_id, curso_id),\n" +
                "    FOREIGN KEY (aluno_id) REFERENCES Alunos(id),\n" +
                "    FOREIGN KEY (curso_id) REFERENCES Cursos(id)\n" +
                ");";

        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434/")
                .modelName("llama3")
                .temperature(0.8)
                .build();

        // Lendo a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua consulta SQL:");
        String userQuery = scanner.nextLine();
        
        // Gerando a resposta do modelo
        String resposta = model.generate("Please respond only using SQL queries. Do not use natural language in your responses" + schemaDefinition + userQuery);
        
        Connection connection = Data.getConnection();
        if (connection != null) {
            try {
                String sqlQuery = resposta;
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

                // Imprimindo a consulta SQL
                System.out.println("Consulta SQL: " + sqlQuery);

                // Executando a consulta
                ResultSet resultSet = preparedStatement.executeQuery();

                // Imprimindo os nomes das colunas
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(metaData.getColumnName(i) + "\t");
                }
                System.out.println();

                // Imprimindo as linhas de dados
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }

                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Data.closeConnection();
            }
        }
    }
}
