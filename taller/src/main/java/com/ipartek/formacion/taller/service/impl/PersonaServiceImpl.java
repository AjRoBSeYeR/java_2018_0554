package com.ipartek.formacion.taller.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.taller.modelo.dao.PersonaDAO;
import com.ipartek.formacion.taller.modelo.dao.VehiculoDAO;
import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaDAO personaDAO;
	
	@Autowired
	VehiculoDAO vehiculoDAO;

	@Override
	public ArrayList<Persona> listar() {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.addAll(personaDAO.getAll().values());

		return personas;
	}

	@Override
	public ArrayList<Vehiculo> vehiculos(int idPersona) {
		
		return vehiculoDAO.getAllByPersonaId(idPersona);
	}

}
