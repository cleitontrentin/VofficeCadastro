/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author cleiton
 */
public interface ProdutoDao {
        public abstract void salvar(Produto produto);
        public abstract void atualizar(Produto produto);
	public abstract void excluir(int id);
	public abstract Produto getProdutoByID(int id);
	public List<Produto> getProdutos();
}
