/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import service.ProdutoService;
import service.ProdutoServiceImpl;
import view.TelaCadastroDeProduto;

/**
 *
 * @author cleiton
 */
public class ControllerProduto {

    TelaCadastroDeProduto tela = new TelaCadastroDeProduto();
    ProdutoService service = new ProdutoServiceImpl();

    public void salvar(String descricao, int qntd, double preco) {
        service.salvar(descricao, qntd, preco);
    }

    public void alterar(int id, String descricao, int qntd, double preco) {
        service.alterar(id, descricao, qntd, preco);

    }

    public void autualizarTabela() {
        service.getProdutos();
    }

    public void excluir(int id) {
        service.excluir(id);
    }
    

}
