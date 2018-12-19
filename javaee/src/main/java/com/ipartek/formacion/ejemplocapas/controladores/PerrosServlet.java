package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.modelo.daos.PerroDAO;
import com.ipartek.formacion.modelo.pojos.Perro;

/**
 * Servlet implementation class PerrosServlet
 */
public class PerrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PerroDAO dao = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//se ejecuta con la 1� petici�n y solo una vez, el resto de peticiones iran al "service"
		dao = new PerroDAO();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		//Se ejecuta al parar el servidor
		
		dao= null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Perro> perros = dao.getAll();
		
	
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
