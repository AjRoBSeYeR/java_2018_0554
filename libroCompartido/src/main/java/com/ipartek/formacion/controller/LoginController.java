package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VISTA_LOGIN = "login.jsp";
	private static final String CONTROLLER_PAGINAS = "privado/pagina.jsp";
    private ArrayList<Usuario> usuarios;
    private final static Logger LOG = Logger.getLogger(LoginController.class);
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(1L, "ander@solana.com", "Pa$$w0rd", "Github"));
		usuarios.add(new Usuario(2L, "daniel@zallo.com", "Pa$$w0rd", "Github"));
		usuarios.add(new Usuario(3L, "solana@ander.com", "Pa$$w0rd", "Github"));
		usuarios.add(new Usuario(4L, "zallo@dani.com", "Pa$$w0rd", "Github"));
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VISTA_LOGIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vista = VISTA_LOGIN;
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String idioma = request.getParameter("idioma");
		String recuerdame = request.getParameter("recuerdame");
		
		
		HttpSession session = request.getSession();
		
		//Idioma
		
		Locale locale = new Locale("eu_ES");
		ResourceBundle messages = ResourceBundle.getBundle("i18nmessages", locale);
		LOG.debug("idioma=" + idioma);
		
		//Guardar cookies
		Cookie cIdioma = new Cookie("cIdioma", idioma);
		cIdioma.setMaxAge(60 * 60 * 24 * 365 * 10);
		response.addCookie(cIdioma);
		
		if (recuerdame != null) {
			Cookie cEmail = new Cookie("cEmail", email);
			cEmail.setMaxAge(60 * 60 * 24 * 365 * 10);
			response.addCookie(cEmail);
		}
		
		
		
		Usuario usuario = new Usuario(null, email, pass, "");
		
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(usuario.getEmail()) && u.getPassword().equals(usuario.getPassword())) {
				vista = CONTROLLER_PAGINAS;
			
				//Asociamos un listener para listar usuarios @see UsuariosListener
				session.setAttribute("language", idioma);
				session.setAttribute("usuario_logueado", usuario);
				break;
			}
		}
		
		if (vista.equals(VISTA_LOGIN)) {
			request.setAttribute("mensaje", messages.getString("login.incorrecto"));
			request.getSession().invalidate();
		}
		
		request.getRequestDispatcher(vista).forward(request, response);
		
	}

}
