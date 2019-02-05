package com.ipartek.formacion.taller.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.ipartek.appMultas.modelo.dao.ConnectionManager;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;

@Repository
public class CombustibleDAO {
	private static final String SQL_GET_ALL = "SELECT id, nombre FROM combustible ORDER BY id DESC;";
	private static final String SQL_GET_BY_ID = "SELECT id, nombre FROM combustible WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM combustible WHERE id = ?;";
	private static final String SQL_INSERT = "INSERT INTO combustible (nombre) VALUES (?);";
	private static final String SQL_UPDATE = "UPDATE combustible SET nombre = ? WHERE id = ? ";

	public ArrayList<Combustible> getAll() {

		ArrayList<Combustible> lista = new ArrayList<Combustible>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_ALL);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				lista.add(mapeo(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Combustible getById(int idCombustible) {
		Combustible c = new Combustible();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GET_BY_ID);) {
			pst.setInt(1, idCombustible);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					c = mapeo(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	public boolean delete(int idCombustible) throws SQLException {
		boolean d = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {
			pst.setInt(1, idCombustible);

			if (pst.executeUpdate() == 1) {
				d = true;
			}
		}

		return d;
	}

	public boolean insert(Combustible combustible) throws SQLException {
		boolean i = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, combustible.getNombre());
			int result = pst.executeUpdate();

			if (result >= 1) {
				try(ResultSet generatedKeys = pst.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						combustible.setId(generatedKeys.getInt(1));
					}
				}
				i = true;
			}
		}
		return i;
	}
	
	public boolean update(Combustible combustible) throws SQLException {
		boolean d = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {
			pst.setString(1, combustible.getNombre());
			pst.setInt(2, combustible.getId());

			if (pst.executeUpdate() == 1) {
				d = true;
			}
		}
		return d;
	}

	private Combustible mapeo(ResultSet rs) throws SQLException {
		Combustible c = new Combustible();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));
		return c;
	}

}
