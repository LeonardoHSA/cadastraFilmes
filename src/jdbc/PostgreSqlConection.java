/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class PostgreSqlConection {
    
    public Connection conecta(){
        
        try {
            
            return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/filmes", "postgres", "+de8000"); //String de conexão
            
        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }
    }
}
