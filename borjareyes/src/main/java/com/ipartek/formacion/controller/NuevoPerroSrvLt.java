package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ipartek.formacion.modelos.Perro;

@WebServlet("/nuevoperro")
public class NuevoPerroSrvLt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidatorFactory factory;
	private Validator validator;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		factory  = Validation.buildDefaultValidatorFactory();
    	validator  = factory.getValidator();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String raza=request.getParameter("raza");
		String chip=request.getParameter("chip");
		ArrayList<Perro> perros= (ArrayList<Perro>) request.getServletContext().getAttribute("perros");
		Perro perro = new Perro(nombre,raza,chip);
		
			
			Set<ConstraintViolation<Perro>> violations = validator.validate(perro);
			
			if (violations.size() > 0) {	
				request.setAttribute("error", "algo no va bien con los datos introducidos");
				request.getRequestDispatcher("/privado/principal.jsp").forward(request, response);
				
			}else {
				
				perros.add(perro);
				
				request.getServletContext().setAttribute("perros", perros);
				
				request.getRequestDispatcher("perros").forward(request, response);
			}
			
	}

}
