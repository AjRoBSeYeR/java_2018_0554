package com.ipartek.formacion.ejemplocapas.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.modelo.daos.VideoDao;
import com.ipartek.formacion.modelo.pojos.Video;

/**
 * Servlet implementation class CarritoController
 */
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//RECIBIR PARAMETROS EN ESTE CASO EL id
		String id = request.getParameter("id");
		
		
		//BUSCAR EN BASE DATOS EL VIDEO POR ID
		VideoDao dao = new VideoDao();
		Video videoRecogido= dao.getById(Long.parseLong(id));
		
		//RECUPERAMOS CARRITO DE SESION DEL USUARIO
		HttpSession session= request.getSession();
		ArrayList<Video> carrito = (ArrayList<Video>)session.getAttribute("carrito") ;
		
		if(carrito == null){
			carrito = new ArrayList<>();

		}
		//A�ADIR EL NUEVO VIDEO A LA SESION DEL CARRITO
		carrito.add(videoRecogido);
		
		//GUARDAMOS EL CARRITO EN SESION DE NUEVO
		session.setAttribute("carrito", carrito);
		
		//REDIRECT A VIDEOCONTROLLER
		response.sendRedirect("videos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RECIBIR PARAMETROS EN ESTE CASO EL id
				String id = request.getParameter("id");
		//RECUPERAMOS CARRITO DE SESION DEL USUARIO
				HttpSession session= request.getSession();
				ArrayList<Video> carrito = (ArrayList<Video>)session.getAttribute("carrito") ;
				
				for(Video v: carrito){
					if(v.getId()==Long.parseLong(id)) {
						carrito.remove(v);
						break;
					}
				}
				//GUARDAMOS EL CARRITO EN SESION DE NUEVO
				session.setAttribute("carrito", carrito);
				
				//REDIRECT A VIDEOCONTROLLER
				response.sendRedirect("videos");		
				
	}

}
