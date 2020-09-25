package br.edu.insper.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;






public class DAO {
	
	private Connection connection = null;
	
	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/organizador", "LaisNSilva", "30270604");
		
	}
	
	public List<Tarefas> getLista(String usuario) throws SQLException{
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefas WHERE nome=?");
		stmt.setString(1, usuario);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setMateria(rs.getString("materia"));
			tarefa.setTarefa(rs.getString("tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setAnotacao(rs.getString("anotacao"));
			tarefas.add(tarefa);
		}
		
		rs.close();
		stmt.close();
		
		return tarefas;
		
		
	}
	
	public void adiciona(Tarefas tarefa) throws SQLException {
		String sql = "INSERT INTO Tarefas(nome, materia, tarefa, data, anotacao) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNome());
		stmt.setString(2, tarefa.getMateria());
		stmt.setString(3, tarefa.getTarefa());
		stmt.setDate(4, new java.sql.Date(
				tarefa.getData().getTimeInMillis()));

		stmt.setString(5, tarefa.getAnotacao());
		stmt.execute();
		stmt.close();
	}
	
	public void deleta (Tarefas tarefa) throws SQLException {
		String sql = "DELETE FROM Tarefas WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, Integer.valueOf(tarefa.getId()));
		
		stmt.execute();
		stmt.close();
		
	}
	
	public void edita (Tarefas tarefa) throws SQLException {
		String sql = "UPDATE Tarefas SET nome=?, materia=?, tarefa=?, data=?, anotacao=? WHERE id=? ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, tarefa.getNome());
		stmt.setString(2, tarefa.getMateria());
		stmt.setString(3, tarefa.getTarefa());
		stmt.setDate(4, new java.sql.Date(
				tarefa.getData().getTimeInMillis()));

		stmt.setString(5, tarefa.getAnotacao());
		
		stmt.setInt(6, tarefa.getId());
		
		stmt.execute();
		stmt.close();
		
	}
	
	public List<Tarefas> getOrderbyMateria(String usuario) throws SQLException{
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefas WHERE nome=? ORDER BY materia");
		stmt.setString(1, usuario);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setMateria(rs.getString("materia"));
			tarefa.setTarefa(rs.getString("tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setAnotacao(rs.getString("anotacao"));
			tarefas.add(tarefa);
		}
		
		rs.close();
		stmt.close();
		
		return tarefas;
		
	}
		
		public List<Tarefas> getOrderbyData(String usuario) throws SQLException{
			List<Tarefas> tarefas = new ArrayList<Tarefas>();
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefas WHERE nome=? ORDER BY data");
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Tarefas tarefa = new Tarefas();
				tarefa.setId(rs.getInt("id"));
				tarefa.setNome(rs.getString("nome"));
				tarefa.setMateria(rs.getString("materia"));
				tarefa.setTarefa(rs.getString("tarefa"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				tarefa.setData(data);
				tarefa.setAnotacao(rs.getString("anotacao"));
				tarefas.add(tarefa);
			}
			
			rs.close();
			stmt.close();
			
			return tarefas;
		
	}
	
	public void cadastrar(Logins login) throws SQLException {
		String sql = "INSERT INTO Login(nome, user, senha) VALUES (?, ?, ?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, login.getNome());
		stmt.setString(2, login.getUser());
		stmt.setString(3, login.getSenha());
		stmt.execute();
		stmt.close();
	}
	
	public String entrar(String usuario, String senha) throws SQLException {
		PreparedStatement stmt;
		Logins login = new Logins();
		
		String sql = "SELECT nome FROM Login WHERE user=? AND senha=? ";
		
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, usuario);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()){
		login.setNome(rs.getString("nome"));
		}
		
		String nomeUser = login.getNome();
		
			
		
		rs.close();
		stmt.close();
		
		return nomeUser;
		
		
	}
	
	public List<Tarefas> filtro(String usuario, String filter) throws SQLException{
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefas WHERE nome=? AND materia LIKE ?");
		stmt.setString(1, usuario);
		stmt.setString(2, filter);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setMateria(rs.getString("materia"));
			tarefa.setTarefa(rs.getString("tarefa"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data"));
			tarefa.setData(data);
			tarefa.setAnotacao(rs.getString("anotacao"));
			tarefas.add(tarefa);
		}
		
		rs.close();
		stmt.close();
		
		return tarefas;
	
	}
	
	public void close() throws SQLException {
		connection.close();
	}

}
