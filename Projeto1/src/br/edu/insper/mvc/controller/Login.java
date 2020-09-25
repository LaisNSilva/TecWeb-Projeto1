package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Logins;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao;
		try {
			dao = new DAO();
		
		
		Logins login = new Logins();
		String nomeUsuario;
		
		login.setUser(request.getParameter("user"));
		login.setSenha(request.getParameter("senha"));
		
		
		nomeUsuario= dao.entrar(login.getUser(), login.getSenha());
		System.out.println(nomeUsuario);
		
		 //request.setAttribute("nomeUsuario", nomeUsuario);
		 //RequestDispatcher stmt = request.getRequestDispatcher("WEB-INF/views/lista.jsp Lista");
		 //stmt.forward(request, response);
		 
		 request.setAttribute("nomeUsuario", nomeUsuario);
		 RequestDispatcher rd = request.getRequestDispatcher("Lista");
		 rd.forward(request, response);
		 //RequestDispatcher rd1 = request.getRequestDispatcher("OrderByData");
		 //rd1.forward(request, response);
		 //RequestDispatcher rd2 = request.getRequestDispatcher("OrderByMateria");
		 //rd2.forward(request, response);
		 
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
