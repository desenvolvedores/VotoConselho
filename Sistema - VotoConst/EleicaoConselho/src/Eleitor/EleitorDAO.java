/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleitor;

import ClassFactory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jenny
 */
public class EleitorDAO {

    public java.sql.Connection connection;
    public ConnectionFactory conn;
    //Query SQL - Adicionar novo Eleitor
    private static final String ADICIONA_ELEITOR = "insert into eleitor (nome, titulo, rg, cpf, sala, status) "
            + "values (?, ?, ?, ?, ?, ?)";
    //Query SQL - desabilita Eleitor
    private static final String DESABILITAR_ELEITOR = "update eleitor set status = '0'  where titulo = '";
    //Query SQL - Seleciona Eleitor
    private static final String SELECIONA_ELEITOR = "select * from eleitor where status != '0' && titulo ='";
    
    //-----------------
    private String blank = "";
    private String result_inserir = blank;
    private String result_buscar = blank;
    private String result_Excluir = blank;
    //-----------------
    public static final String SUCESSO_INSERCAO = "success";
    public static final String FALHA_INSERCAO = "failure";
    public static final String SUCESSO_BUSCAR = "success";
    public static final String FALHA_BUSCAR = "failure";
    public static final String SUCESSO_EXCLUIR = "success";
    public static final String FALHA_EXCLUIR = "failure";

    public EleitorDAO() {

        conn = new ConnectionFactory();
        connection = conn.useConnection();
    }

    //Adiciona
    public String adicionaEleitor(Eleitor eleitor) {
        try {
            PreparedStatement stmt = connection.prepareStatement(ADICIONA_ELEITOR);

            stmt.setString(1, eleitor.getNome());
            stmt.setString(2, eleitor.getTitulo());
            stmt.setString(3, eleitor.getRg());
            stmt.setString(4, eleitor.getCpf());
            stmt.setString(5, eleitor.getSala());
            stmt.setString(6, eleitor.getStatus());

            stmt.execute();
            stmt.close();

            result_inserir = SUCESSO_INSERCAO;

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getLocalizedMessage());
            result_inserir = FALHA_INSERCAO;
        } catch (Exception e) {
            throw new RuntimeException("Erro " + e);
        }

        return result_inserir;
    }

    //Verificar se o Eleitor já está cadastrado
    public List<Eleitor> getListaEleitor(Eleitor eleitor) throws SQLException {

        PreparedStatement sql = this.connection.prepareStatement(SELECIONA_ELEITOR + eleitor.getTitulo() + "';");
        ResultSet rs = sql.executeQuery();

        List<Eleitor> lista = new ArrayList<Eleitor>();
        try {

            while (rs.next()) {

                eleitor.setNome(rs.getString("nome"));
                eleitor.setSala(rs.getString("sala"));
                eleitor.setTitulo(rs.getString("titulo"));
                eleitor.setRg(rs.getString("rg"));
                eleitor.setCpf(rs.getString("cpf"));
                

                lista.add(eleitor);
            }

            rs.close();
            sql.close();

            result_buscar = SUCESSO_BUSCAR;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o Eleitor: " + e.getStackTrace());
            result_buscar = FALHA_BUSCAR;
        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e.getLocalizedMessage());
        }
        return lista;
    }

    //Verifica se o eleitor já está cadastrado
    public boolean validarTitulo(Eleitor eleitor) {
        boolean verifica = false;

        try {
            
            PreparedStatement sql = this.connection.prepareStatement(SELECIONA_ELEITOR + eleitor.getTitulo() + "';");
            ResultSet rs = sql.executeQuery();

            if (rs != null && rs.next()) {
                verifica = true;
            } else {
                verifica = false;
            }
        } catch (java.sql.SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
        }
        return verifica;
    }

    //Exclui Eleitor
    public void deletarEleitor(Eleitor eleitor) throws SQLException {
        PreparedStatement sql = (PreparedStatement) this.connection.prepareStatement(DESABILITAR_ELEITOR + eleitor.getTitulo() + "';");
        sql.executeUpdate();
    }
}
