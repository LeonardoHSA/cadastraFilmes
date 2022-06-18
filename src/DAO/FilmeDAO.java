/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    // Listar todos os funcionários
    public List<Filme> listarFilmes(){
        
        try {
            // criando o vetor que vai armazenar os registros do banco
            List<Filme> lista = new ArrayList<Filme>();
            
            // criando o comando sql
            String cmdSql = "select * from public.filmes";
            
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);
            
            // guardando o resultado do select dentro de um objeto result set
            ResultSet rs = stmt.executeQuery();
            
            // enquanto houver registros, guarde o registro na fila
            while(rs.next()){
                Filme f = new Filme();
                f.setCodigoFilme(rs.getInt("codigoFilme"));
                f.setNome(rs.getString("nome"));
                f.setGenero(rs.getString("genero"));
                f.setDiretor(rs.getString("diretor"));
                f.setStreamer(rs.getString("streamer"));
                f.setAno(Integer.parseInt(rs.getString("ano")));
                
                lista.add(f);
            }
            
            return lista;
        } catch (Exception erroSql) {
            throw new RuntimeException(erroSql);
        }
    }
}
