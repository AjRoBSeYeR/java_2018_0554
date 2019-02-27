package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.MultaDAO;
import com.ipartek.formacion.modelo.pojo.Multa;


@CrossOrigin
@RestController
public class MultaController {
	
	private final static Logger LOG = Logger.getLogger(MultaController.class);
	public static MultaDAO multaDao;
	
	public MultaController() {
		super();
		multaDao = MultaDAO.getInstance();
		
	}

	
	@RequestMapping( value= {"/api/agente/{id}/multa"}, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Multa>> listar(@PathVariable Long id){
		ResponseEntity<ArrayList<Multa>> response = new ResponseEntity<ArrayList<Multa>>(HttpStatus.NOT_FOUND);
		HashMap<Long, Multa> hmMultas;
		try {
			hmMultas = multaDao.getAllByIdAgente(id);
			ArrayList<Multa> multas = new ArrayList<Multa>(hmMultas.values());
			if (multas.size() > 0) {
				response = new ResponseEntity<ArrayList<Multa>>(multas, HttpStatus.OK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
}

