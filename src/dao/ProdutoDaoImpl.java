/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author cleiton
 */
public class ProdutoDaoImpl implements ProdutoDao {

    private final String INSERT = "INSERT INTO PRODUTO (DESCRICAO, QUANTIDADE, PRECO) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE PRODUTO SET DESCRICAO=?, QUANTIDADE=?, PRECO=? WHERE ID=?";
    private final String DELETE = "DELETE FROM PRODUTO WHERE ID =?";
    private final String LIST = "SELECT * FROM PRODUTO";
    private final String LISTBYID = "SELECT * FROM PRODUTO WHERE ID=?";

    @Override
    public void salvar(Produto produto) {
         if (produto != null) {
            Connection conn = null;
            try {
                conn = ConectionFactory.getConnection();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(INSERT);

                pstm.setString(1, produto.getDescricao());
                pstm.setInt(2, produto.getQntd());
                pstm.setDouble(3, produto.getPreco());

                pstm.execute();
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir Produto no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            System.out.println("O Produto enviado por parâmetro está vazio");
        }
    }
    @Override
    public void atualizar(Produto produto) {
        if (produto != null) {
            Connection conn = null;
            try {
                conn = ConectionFactory.getConnection();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(UPDATE);

                pstm.setString(1, produto.getDescricao());
                pstm.setInt(2, produto.getQntd());
                pstm.setDouble(3, produto.getPreco());
                pstm.setInt(4, produto.getId());
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Produto no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "O Produto enviado por parâmetro está vazio");
        }

    }
    @Override
    public void excluir(int id) {
		Connection conn = null;
		try {
			conn = ConectionFactory.getConnection();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			System.out.println( "Erro ao excluir Produto do banco de" + "dados " + e.getMessage());
		}
	}

    @Override
    public List<Produto> getProdutos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Produto> ListaProdutos = new ArrayList();
        try {
            conn = ConectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQntd(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));

                ListaProdutos.add(produto);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Produto" + e.getMessage());
        }
        return ListaProdutos;
    }

    @Override
    public Produto getProdutoByID(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;
        conn = ConectionFactory.getConnection();
        try {
            stmt = conn.prepareStatement(LISTBYID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descrição"));
                produto.setQntd(rs.getInt("Quantidade"));
                produto.setPreco(rs.getDouble("Preço"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }
    @Override
    public ArrayList<Produto> retornar(String parametroPesquisa){
        ArrayList<Produto> lista = new ArrayList();
        Connection con = ConectionFactory.getConnection();
        try{
        String sql = "SELECT * FROM PRODUTO";
        if (parametroPesquisa.length()>0){
            sql+=" where nome like '%"+parametroPesquisa+"%'";
        }
        PreparedStatement ps = con.prepareStatement(sql); 	
        ResultSet rs = ps.executeQuery();
       while (rs.next ()) {
            Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQntd(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
           lista.add(produto);
       }
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro na execução do sql: "+e);
        }
        return lista;
    }

}
