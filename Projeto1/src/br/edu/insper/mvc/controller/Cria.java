package br.edu.insper.mvc.controller;


import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefas;

/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/formCria.html");
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
		
		
		Tarefas tarefa = new Tarefas();
		
		tarefa.setNome(request.getParameter("nome"));
		tarefa.setMateria(request.getParameter("materia"));
		tarefa.setTarefa(request.getParameter("tarefa"));
		
		String entrega = request.getParameter("data");
		Date data;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(entrega);
			Calendar dataEntrega = Calendar.getInstance();
			dataEntrega.setTime(data);
			tarefa.setData(dataEntrega);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		tarefa.setAnotacao(request.getParameter("anotacao"));
		
		dao.adiciona(tarefa);
		
		
		dao.close();
		//response.sendRedirect("Lista");
		String nomeUsuario = tarefa.getNome();
		request.setAttribute("nomeUsuario", nomeUsuario);
		RequestDispatcher rd = request.getRequestDispatcher("Lista");
		rd.forward(request, response);
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
