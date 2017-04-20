/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import service.ClienteServiceImpl;

/**
 *
 * @author cleiton
 */
public class ControllerCliente {

    ClienteServiceImpl service = new ClienteServiceImpl();
    
    public void salvar(String nome, Calendar dataNascimento, String cpf, String telefone,
            String telCelular, String email, String rua, int numero, int complemento, String bairro,
            String cidade, String cep) {
        service.inserir(nome, dataNascimento, cpf, telefone, telCelular, email, rua, numero,
                complemento, bairro, cidade, cep);
        
    }
    
}
