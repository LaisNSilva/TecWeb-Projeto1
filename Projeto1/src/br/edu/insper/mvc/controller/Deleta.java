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
import br.edu.insper.mvc.model.Tarefas;

/**
 * Servlet implementation class Deleta
 */
@WebServlet("/Deleta")
public class Deleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao;
		
		try {
			dao = new DAO();
		
		
		Tarefas tarefa = new Tarefas();
		
		String identificador = request.getParameter("id");
		Integer id = Integer.parseInt(identificador);
		tarefa.setId(id);
		
		dao.deleta(tarefa);

		String nomeUsu = request.getParameter("nome");
		request.setAttribute("nomeUsuario", nomeUsu);
		RequestDispatcher rd = request.getRequestDispatcher("Lista");
		rd.forward(request, response);
		//dao.close();
		//response.sendRedirect("Lista");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
