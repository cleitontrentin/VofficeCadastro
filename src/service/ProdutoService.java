/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author cleiton
 */
public interface ProdutoService{
        public  void salvar(String descricao, int qntd, double preco);
        public  void alterar(int id,String descricao, int qntd, double preco);
	public  void excluir(int id);
	public  Produto getProdutoByID(int id);
        public abstract List<Produto> getProdutos();
}
