/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ClienteDaoImpl;
import java.util.Calendar;
import java.util.List;
import model.Cliente;
import model.Produto;

/**
 *
 * @author cleiton
 */
public class ClienteServiceImpl implements ClienteService{
ClienteDaoImpl dao = new ClienteDaoImpl();
    @Override
    public void inserir(String nome, Calendar dataNascimento, String cpf, String telefone,
            String telCelular, String email, String rua, int numero, int complemento, String bairro,
            String cidade, String cep) {
        Cliente cliente = new Cliente();
        if(cliente.getId() == 0){
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setTelCelular(telCelular);
            cliente.setEmail(email);
            cliente.setRua(rua);
            cliente.setNumero(numero);
            cliente.setComplemento(complemento);
            cliente.setBairro(bairro);
            cliente.setCidade(cidade);
            cliente.setCep(cep);
            dao.salvar(cliente);
                    
        }

    }

    @Override
    public void alterar(int id, String nome, Calendar dataNascimento, String cpf, String telefone, String telCelular, String email, String rua, int numero, int complemento, String bairro, String cidade, String cep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getAllClientes() {
      return dao.getAllClientes();
    }


}
