/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Cliente;

/**
 *
 * @author cleiton
 */
public interface ClienteDao {

	public abstract void salvar(Cliente cliente);
	public abstract void excluir(String cpf);
//	public abstract Cliente getContatoByCPF(String cpf);
	public abstract List<Cliente> getAllClientes();
    
}
