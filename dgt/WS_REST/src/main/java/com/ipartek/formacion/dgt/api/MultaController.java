package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.appMultas.modelo.dao.CocheDAO;
import com.ipartek.appMultas.modelo.dao.MultaDAO;
import com.ipartek.appMultas.modelo.pojo.Coche;
import com.ipartek.appMultas.modelo.pojo.Multa;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@Api(tags = { "MULTAS" }, produces="application/json", value="Gestión de Multas")

public class MultaController {

	private final static Logger LOG = Logger.getLogger(MultaController.class);
	public static MultaDAO multaDao;
	private ValidatorFactory factory;
	 private Validator validator;
	
	public MultaController() {
		super();
		multaDao = MultaDAO.getInstance();
		//Crear Factoria y Validador
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	/**
	 * Obtiene un listado de todas las multas registradas de un agente concreto.
	 * @return OK(200) Si existen multas para ese agente en la BD. Además devolverá todas las multas
	 * @return NOT_FOUND(404) Si no existen multas en la BD para ese agente.
	 */
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Hay multas registrados en la Base de Datos para el agente, se devuelve una lista con ellas."),
			@ApiResponse(code = 404, message="No existen multas en la Base de datos para dicho agente.")
	})
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
