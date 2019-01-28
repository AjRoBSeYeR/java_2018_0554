package com.ipartek.formacion.modelo.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.cm.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Coche;

public class CocheDAO {

	private final static Logger LOG = Logger.getLogger(CocheDAO.class);
	private static CocheDAO INSTANCE = null;
	private static final String SQL_GETMATRICULA = "{call pa_coche_getByMatricula(?)}";
	private static final String SQL_GETALL = "SELECT * FROM coche ORDER BY id DESC LIMIT 100";
	private static final String SQL_BYID = "SELECT * FROM COCHE WHERE ID=?";
	private static final String SQL_DELETEBYID = "DELETE FROM coche WHERE id = ?;";
	private static final String SQL_INSERT = "{call pa_coche_insert(?,?,?,?)}";
	private static final String SQL_UPDATE = "{call pa_coche_update(?,?,?)}";

	private CocheDAO() {
		super();
	}

	public synchronized static CocheDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CocheDAO();
		}
		return INSTANCE;
	}

	/**
	 * Obtenemos un Coche por su matricula
	 * 
	 * @param matricula
	 * @return Coche si encuentra, null en caso contrario
	 */
	public Coche getByMatricula(String matricula) {
		Coche c = null;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_GETMATRICULA);) {

			cs.setString(1, matricula);

			try (ResultSet rs = cs.executeQuery()) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}

		} catch (Exception e) {
			LOG.error(e);
		}
		return c;
	}

	/**
	 * obtenemos un coche por su identificador
	 * 
	 * @param id
	 * @return coche con datos, null si no encuentra
	 */
	public Coche getById(long id) {

		Coche c = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_BYID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					c = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return c;

	}

	/**
	 * obtiene una coleccion de Coche ordenado por identificador descendente y
	 * limitados a 100
	 * 
	 * @return si no existe ningun new ArrayList<Coche>
	 */
	public ArrayList<Coche> getAll() {

		ArrayList<Coche> coches = new ArrayList<Coche>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Coche coche = new Coche();
					coche.setId(rs.getLong("id"));
					coche.setMatricula(rs.getString("matricula"));
					coche.setKm(rs.getInt("km"));
					coche.setModelo(rs.getString("modelo"));
					coches.add(coche);
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return coches;
	}

	// ELIMINAR

	/**
	 * Eliminar un coche de la base de datos
	 * 
	 * @param id identificador del coche
	 * @return true si elimina, false en caso contrario
	 * @throws SQLException si el coche tiene alguna multa asociada (integridad
	 *                      referencial)
	 */

	public boolean eliminar(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_DELETEBYID);) {

			cs.setLong(1,id);
			
			if (cs.executeUpdate() == 1) {
				resul = true;
			}

		}
		return resul;

	}

	// INSERTAR

	/**
	 * inserta un nuevo Coche (matricula, modelo, km)
	 * 
	 * @param coche con datos
	 * @return Coche con los mismos datos y la id generada 
	 * @throws SQLException si la matricula ya existe
	 */

	public Coche insert(Coche coche) throws SQLException{

		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_INSERT);) {
			cs.setString(1, coche.getMatricula());
			cs.setString(2, coche.getModelo());
			cs.setInt(3, coche.getKm());
			cs.registerOutParameter(4, Types.INTEGER);
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				coche.setId(cs.getLong(4));
			}else {
				coche=null;
			}
		}
		return coche;
	}

	/**
	 * Actualizar un coche menos su id y matricula @param coche @throws
	 * SQLException @returntrue si se modifica, false e caos contrario @throws
	 */
	public boolean update(Coche coche) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				CallableStatement cs = conn.prepareCall(SQL_UPDATE);) {

			cs.setString(1, coche.getModelo());
			cs.setInt(2, coche.getKm());
			cs.setLong(3, coche.getId());
			int affectedRows = cs.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;
	}

	private Coche rowMapper(ResultSet rs) throws SQLException {
		Coche c = new Coche();
		c.setId(rs.getLong("id"));
		c.setMatricula(rs.getString("matricula"));
		c.setModelo(rs.getString("modelo"));
		c.setKm(rs.getInt("km"));
		return c;
	}
}