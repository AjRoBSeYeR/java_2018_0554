package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.taller.modelo.config.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Rol;

@Repository
public class PersonaDAO {
	// LOG
	private final static Logger LOG = Logger.getLogger(PersonaDAO.class);

	private static final String SQL_GET_ALL = "SELECT p.id as 'id_persona', p.nombre as 'nombre_persona', r.id as 'id_rol', r.nombre as 'nombre_rol', p.dni AS 'dni_persona', p.telefono AS 'telefono_persona', p.apellidos AS 'apellido_persona' FROM persona as p, persona_has_rol as pr, rol as r WHERE p.id = pr.id_persona AND pr.id_rol = r.id ORDER BY p.id DESC LIMIT 1000;";
	private static final String SQL_GET_BY_ID = "SELECT p.id as 'id_persona', p.nombre as 'nombre_persona', r.id as 'id_rol', r.nombre as 'nombre_rol', p.dni AS 'dni_persona', p.telefono AS 'telefono_persona', p.apellidos AS 'apellido_persona' FROM persona as p, persona_has_rol as pr, rol as r WHERE p.id = pr.id_persona AND pr.id_rol = r.id AND p.id = ? ;";

	/**
	 * Obtener todas las de Personas
	 * 
	 * @return HashMap de Persona
	 */
	public HashMap<Integer, Persona> getAll() {

		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				int idPersona = rs.getInt("id_persona");
				Persona persona = hmPersonas.get(idPersona);

				if (persona == null) { // si no encuentra crear
					persona = new Persona();
					persona.setId(idPersona);
					persona.setNombre(rs.getString("nombre_persona"));
					persona.setDni(rs.getString("dni_persona"));
					persona.setTelefono(rs.getString("telefono_persona"));
					persona.setApellidos(rs.getString("apellido_persona"));
				}

				Rol rol = new Rol();
				rol.setId(rs.getInt("id_rol"));
				rol.setNombre(rs.getString("nombre_rol"));

				ArrayList<Rol> roles = persona.getRoles();
				roles.add(rol);
				persona.setRoles(roles);

				// guardar en hasMap
				hmPersonas.put(idPersona, persona);

			} // end while

		} catch (Exception e) {
			LOG.debug(e);
		}

		return hmPersonas;
	}

	public HashMap<Integer, Persona> getById(int id_persona) {

		HashMap<Integer, Persona> hmPersonas = new HashMap<Integer, Persona>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, id_persona);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {

					int idPersona = rs.getInt("id_persona");
					Persona persona = hmPersonas.get(idPersona);

					if (persona == null) {
						persona = new Persona();
						persona.setId(idPersona);
						persona.setNombre(rs.getString("nombre_persona"));
						persona.setDni(rs.getString("dni_persona"));
						persona.setTelefono(rs.getString("telefono_persona"));
						persona.setApellidos(rs.getString("apellido_persona"));
					}

					Rol rol = new Rol();
					rol.setId(rs.getInt("id_rol"));
					rol.setNombre(rs.getString("nombre_rol"));

					ArrayList<Rol> roles = persona.getRoles();
					roles.add(rol);
					persona.setRoles(roles);

					hmPersonas.put(idPersona, persona);

				} // end while
			} catch (SQLException e) {
				LOG.debug(e);
			}
		} catch (Exception e) {
			LOG.debug(e);
		}

		return hmPersonas;
	}

}
