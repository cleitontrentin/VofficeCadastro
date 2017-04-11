/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProdutoDao;
import dao.ProdutoDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author cleiton
 */
public class ProdutoServiceImpl implements ProdutoService {

    ProdutoDao dao = new ProdutoDaoImpl();

    @Override
    public void salvar(String descricao, int qntd, double preco) {
        Produto produto = new Produto();
        if (produto.getId() == 0) {
            produto.setDescricao(descricao);
            produto.setQntd(qntd);
            produto.setPreco(preco);
            dao.salvar(produto);
        }
    }

    @Override
    public void alterar(int id, String descricao, int qntd, double preco) {
        Produto produto = new Produto();
       
            produto.setId(id);
            produto.setDescricao(descricao);
            produto.setQntd(qntd);
            produto.setPreco(preco);
            dao.atualizar(produto);
            
        
    }

    @Override
    public void excluir(int id) {
        dao.excluir(id);
    }

    @Override
    public Produto getProdutoByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> getProdutos() {
       return dao.getProdutos();
        
    }
}
