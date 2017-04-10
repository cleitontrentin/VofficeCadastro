/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cleiton
 */
public class ConectionFactory {
    
                private static final String USUARIO = "root";
		private static final String SENHA ="root";
		private static final String DATABASE = "ERPROSATRAPO";
		private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
		private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/" + DATABASE;
	        
		public static Connection getConnection(){

			Connection conn = null;
			try {
					conn = DriverManager.getConnection(STR_CONEXAO , USUARIO, SENHA);
				System.out.println("Conectado");

			} catch (SQLException e) {
				System.out.println("Erro ao obter a Conexão!");
				e.printStackTrace();
			}
			return conn;
			
		}
}
