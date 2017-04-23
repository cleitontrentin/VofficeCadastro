/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Produto;

/**
 * CREATE TABLE CLIENTE( ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, NOME
 * VARCHAR(255), DATANASCIMENTO DATE, CPF VARCHAR(11), TELEFONE VARCHAR(10),
 * CELULAR VARCHAR(11), EMAIL VARCHAR(255), RUA VARCHAR(255), NUMERO INT,
 * COMPLEMENTO INT, BAIRRO VARCHAR(255), CIDADE VARCHAR(255), CEP VARCHAR(8) );
 *
 * @author cleiton
 */
public class ClienteDaoImpl implements ClienteDao {

    private final String INSERT = "INSERT INTO CLIENTE (NOME, DATANASCIMENTO, CPF,"
            + "TELEFONE,CELULAR,EMAIL,RUA,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,CEP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE CLIENTE SET NOME=?, DATANASCIMENTO=?, PRECO=?, TELEFONE=?,"
            + "CELULAR=? ,EMAIL=? ,RUA=? ,NUMERO=? ,COMPLEMENTO=? ,BAIRRO=? ,CIDADE=? ,CEP=?  WHERE ID=?";
    private final String DELETE = "DELETE FROM CLIENTE WHERE ID =?";
    private final String LIST = "SELECT * FROM CLIENTE";
    private final String LISTBYID = "SELECT * FROM CLIENTE WHERE ID=?";

    @Override
    public void salvar(Cliente cliente) {
        if (cliente != null) {
            Connection conn = null;
            try {
                conn = ConectionFactory.getConnection();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);

                pstm.setString(1, cliente.getNome());
                pstm.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
                pstm.setString(3, cliente.getCpf());
                pstm.setString(4, cliente.getTelefone());
                pstm.setString(5, cliente.getTelCelular());
                pstm.setString(6, cliente.getEmail());
                pstm.setString(7, cliente.getRua());
                pstm.setInt(8, cliente.getNumero());
                pstm.setInt(9, cliente.getComplemento());
                pstm.setString(10, cliente.getBairro());
                pstm.setString(11, cliente.getCidade());
                pstm.setString(12, cliente.getCep());

                pstm.execute();
                JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso");

            } catch (Exception e) {
                System.out.println("Erro ao inserir Cliente no banco de " + "dados " + e.getMessage());
            }
        } else {
            System.out.println("O Cliente enviado por parâmetro está vazio");
        }
    }

    @Override
    public void excluir(String cpf) {
        Connection conn = null;
        try {
            conn = ConectionFactory.getConnection();
            PreparedStatement pstm;
            pstm = conn.prepareStatement(DELETE);

            pstm.setString(1, cpf);

            pstm.execute();
            JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir Cliente do banco de" + "dados " + e.getMessage());
        }
    }



    @Override
   public List<Cliente> getAllClientes() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Cliente> ListaClientes = new ArrayList();
        try {
            conn = ConectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                Date nascimento = rs.getDate("datanascimento");	
            	Calendar cal = Calendar.getInstance(new Locale("pt")); //new GregorianCalendar();
            	cal.setTime(nascimento);
                cliente.setCpf(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setTelCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setComplemento(rs.getInt("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setCep(rs.getString("cep"));

                ListaClientes.add(cliente);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Cliente" + e.getMessage());
        }
        return ListaClientes;
    }
   


}
