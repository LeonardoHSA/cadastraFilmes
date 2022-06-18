/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javaBeans.Filme;
import jdbc.PostgreSqlConection;

/**
 *
 * @author Leonardo
 */
public class FilmeDAO {
    
    private Connection conecta;
    
    public FilmeDAO(){
        this.conecta = new PostgreSqlConection().conecta();
    }
    
    //Método cadastrar Filme
    public void cadastrarFilme(Filme obj){
        
        try {
            
            // criando o comando sql
            String cmdsql = "insert into public.filmes (nome, genero, diretor, streamer, ano) values(?, ?, ?, ?, ?)";
            
            
            // organizando o cmdsql e executando
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getGenero());
            stmt.setString(3, obj.getDiretor());
            stmt.setString(4, obj.getStreamer());
            stmt.setInt(5, obj.getAno());
            
            stmt.execute();
            
            // fechando a conexão
            stmt.close();
            
        } catch (SQLException erroSQL) {
            throw new RuntimeException(erroSQL);
        }
    }
}
