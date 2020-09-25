package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefas;

/**
 * Servlet implementation class OrderByData
 */
@WebServlet("/OrderByData")
public class OrderByData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderByData() {
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
		String nomeUser = request.getParameter("nomeU");
		request.setAttribute("nomeUsuario", nomeUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/lista.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao;
		try {
			dao = new DAO();
		String nomeUser = request.getParameter("nomeU");
		List<Tarefas> tarefas = dao.getOrderbyData(nomeUser);
		
		request.setAttribute("tarefas", tarefas);
		request.setAttribute("nomeUsuario", nomeUser);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/lista.jsp");
		rd.forward(request, response);
		
		dao.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
