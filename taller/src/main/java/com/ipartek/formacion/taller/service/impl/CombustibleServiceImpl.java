package com.ipartek.formacion.taller.service.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.CombustibleDAO;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@Service
public class CombustibleServiceImpl implements CombustibleService {

	@Autowired
	CombustibleDAO combustibleDAO;
	
	
	// LLAMAR A DAO PARA LISTAR (GETALL)
	@Override
	public List<Combustible> listar() {		
		return combustibleDAO.getAll();
	}

	
	// LLAMAR A DAO PARA DETALLE (GETBYID)
	@Override
	public Combustible detalle(int id) {
		return combustibleDAO.getById(id);
	}

	
	@Override
	public boolean eliminar(int idCombustible) throws CombustibleException {		
		boolean isDelete = false;
		try {
			isDelete = combustibleDAO.delete(idCombustible);
		}catch ( SQLException e) {			
			throw new CombustibleException( CombustibleException.EXCEPTION_CONSTRAINT );
		}			
		return isDelete;
	}

	
	@Override
	public boolean crear(Combustible combustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Combustible combustible) throws CombustibleException {
		// TODO Auto-generated method stub
		return false;
	}


}

	
	
	
	
	
	
	
	
	
	
	

