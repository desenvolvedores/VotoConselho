/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jenny
 */
public class ConnectionFactory {

    private static Connection con;

    
    
    public Connection useConnection() {
        return con;
    }
    
    public void getConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/conselho_2013", "root", "");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/conselho_2013", "root", "asgard2!");
            System.err.println("Conexão efetuada com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar (SQLException): " + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao conectar (NotFoundException): " + e);
        }

    }

    public void CloseAll(Connection conn, PreparedStatement stmt) {
        try {

            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao encerrar operação: " + e.getStackTrace()
                    + " \n Verificar: " + e.getLocalizedMessage());
        }
    }
}
