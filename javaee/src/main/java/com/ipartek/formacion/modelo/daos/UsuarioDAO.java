package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;

import com.ipartek.formacion.modelo.pojos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
	
	/**
	 * comprobar si existe el usuario en la bbdd
	 * @param email String 
	 * @param pass String contrase�a
	 * @return usuario con datos si existe, null si no existe
	 */
	public Usuario login (String email, String pass) {
		
		Usuario usuario = null;
		String sql = "SELECT id, nombre, password FROM usuario WHERE nombre = ? AND password = ?;";
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
				){						
					pst.setString(1, email);
					pst.setString(2, pass);			
					try ( ResultSet rs = pst.executeQuery() ){											
							while(rs.next()) { // hemos encontrado usuario								
								usuario = new Usuario();
								usuario.setId( rs.getLong("id"));
								usuario.setEmail( rs.getString("nombre"));
								usuario.setPassword(rs.getString("password"));								
							}						
					}
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return usuario;
	}

}
