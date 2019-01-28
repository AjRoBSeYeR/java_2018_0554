package com.ipartek.formacion.dgt.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.modelo.daos.CocheDAO;
import com.ipartek.formacion.modelo.pojo.Coche;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@CrossOrigin //restriccion de js
@RestController
public class VehiculoController {
	private final static Logger LOG = Logger.getLogger(VehiculoController.class);
	private static CocheDAO cocheDAO;
	
	private ValidatorFactory factory;
	private Validator validator;


	public VehiculoController() {
		super();
		cocheDAO = CocheDAO.getInstance();
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}
	
	//LISTAR
	@RequestMapping(value = { "/api/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Coche> listar() {

		/*
		 * ArrayList<Coche> coches = new ArrayList<Coche>(); coches.add(new Coche (1L,
		 * "BI0000CM", "Fiat", 3455)); coches.add(new Coche (2L, "ZA0000HK",
		 * "Flagoneta", 3455));
		 */
		// return coches;
		return cocheDAO.getAll();
	}

	/*
	 * @RequestMapping(value= {"/api/vehiculo/{id}"}, method = RequestMethod.GET)
	 * public Coche detalle(@PathVariable long id){
	 * 
	 * Coche c = new Coche (2L, "ZA0000HK", "Flagoneta", 3455); c.setId(id);
	 * 
	 * return c;
	 * 
	 * }
	 */
	
	//VEHICULO por id

	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Coche> detalleId(@PathVariable String id){
		/*
		 * ResponseEntity<Coche> response = null;
		 * 
		 * if (id > 0) { Coche c = new Coche(2L, "ZA0000HK", "Flagoneta", 3455);
		 * c.setId(id); response = new ResponseEntity<Coche>(c, HttpStatus.OK); } else
		 * {// coche no existe
		 * 
		 * response = new ResponseEntity<Coche>(c, HttpStatus.NOT_FOUND); }
		 */
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);

		try {
			long identificador = Long.parseLong(id);
			Coche coche = cocheDAO.getById(identificador);
			if(coche == null) {
				response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
			}else {
				response = new ResponseEntity<Coche>(HttpStatus.OK);
			}
		}catch(NumberFormatException e) {
		response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
			
		}catch(Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
		//TODO con dao
	}
	
	
	
	
	
	//ELIMINAR
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Coche> eliminar(@PathVariable long id) throws SQLException {

		
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
	

		try {
			
			if (cocheDAO.eliminar(id)) {				

				response = new ResponseEntity<Coche>(HttpStatus.OK);				
			}
		} catch (SQLException e) {
			//TODO 409 cuando no se pueda eliminar Coche porque tiene multas asociadas
			LOG.debug("No se puede eliminar coche con multas identificador = " + id);
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
		}catch(Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;

	}
	
	//CREAR
	@RequestMapping(value=("/api/vehiculo"), method=RequestMethod.POST)
	public ResponseEntity<Coche> crear(@Valid @RequestBody Coche coche){
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);//404
		
		try {
			Set<ConstraintViolation<Coche>> violations = validator.validate(coche);
			if(violations.size() > 0) {
				response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
			}else {
				Coche c = cocheDAO.insert(coche);
				response = new ResponseEntity<Coche>(HttpStatus.CREATED);
				LOG.info("Nuevo Coche creado " + c);
			}}
		catch(SQLException e){
			LOG.debug("Ya existe matricula " + coche.getMatricula());
			response = new ResponseEntity<Coche>(HttpStatus.CONFLICT);
			
			
			
		}catch(Exception e){
			LOG.error(e);
			response = new ResponseEntity<Coche>( HttpStatus.INTERNAL_SERVER_ERROR );
		}
		
		
		return response;
	
		
	}
		
		
		
		//TODO terminar
		//201 creado y retornar coche con id actualizado
		//400 datos del coche no son correctos, por ejemplo sin matricula o vacia
		//409 ya existe la matricula UK 
	
		
	
	//ACTUALIZAR
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Coche> modificar(@Valid @PathVariable long id, @RequestBody Coche coche ) {
		ResponseEntity<Coche> response = new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		
		try {
			if (cocheDAO.update(coche)) {
				response = new ResponseEntity<Coche>(coche, HttpStatus.OK);
			}
		} catch (SQLException e) {
			LOG.debug("No se ha podido actualizar los datos");
			response = new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOG.error(e);
			response = new ResponseEntity<Coche>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

		
	}
	
	//ACTUALIZAR PARCIAL
	@RequestMapping(value = { "/api/vehiculo/{id}" }, method = RequestMethod.PATCH)
	public ResponseEntity<Coche> darDeBaja(@PathVariable long id, @RequestBody Coche coche) {
		
		//TODO terminar
		return new ResponseEntity<Coche>(HttpStatus.NOT_IMPLEMENTED);
		
	}
	
	
}
