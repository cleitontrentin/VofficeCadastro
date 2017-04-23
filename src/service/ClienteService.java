/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Calendar;
import java.util.List;
import model.Cliente;


/**
 * 
 * @author cleiton
 */
public interface ClienteService {
    public void inserir(String nome, Calendar dataNascimento,String cpf, String telefone,
            String telCelular,String email, String rua, int numero, int complemento, String bairro,
            String cidade, String cep);
    public void alterar(int id,String nome, Calendar dataNascimento,String cpf, String telefone,
            String telCelular,String email, String rua, int numero, int complemento, String bairro,
            String cidade, String cep);
    public void apagar(int id);
    public abstract List<Cliente> getAllClientes();
}
