<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>



<body>
<%@ page import="java.util.*,br.edu.insper.mvc.controller.*" %>
<h1>Bem-vindo a sua página de tarefas!</h1>
<button onclick="window.location.href='Cria'">Criar nova tarefa!</button>



<h2>Tarefas</h2>
<table border="1">
		<tr>
			<td><h4>Ordenar por:</h4></td>
			
			<td><form action="OrderByData" method='post'>
				<input type='hidden' name='nomeU' value='${nomeUsuario}'>
				<input type='submit' value='Data de entrega'>	
				</form></td>
		
			<td><form action="OrderByMateria" method='post'>
			<input type='hidden' name='nomeUsuario' value='${nomeUsuario}'>
				<input type='submit' value='Matéria'>	
				</form></td>
			
			
		</tr>
</table>

<h3>Filtro para Matéria:</h3>
	<form action="Filtro" method='post'>
		<input type='hidden' name='nomeU' value='${nomeUsuario}'>
		<input type='text' name='busca'> 
		<input type='submit' value='Buscar'> 
	</form>
<table border="1">
<c:forEach var="tarefa" items="${tarefas}">
<tr>

<td>${tarefa.nome}</td>
<td>${tarefa.materia}</td>
<td>${tarefa.tarefa}</td>
<td>${tarefa.data.time}</td>
<td>${tarefa.anotacao}</td>
<td>
<form action="Deleta" method='post' >
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='hidden' name='nome' value='${tarefa.nome}'>
<input type='submit' value='APAGAR'>
</form>
</td>
<td>
<form action="Edita" method='get' >
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='hidden' name='nome' value='${tarefa.nome}'>
<input type='hidden' name='materia' value='${tarefa.materia}'>
<input type='hidden' name='tarefa' value='${tarefa.tarefa}'>
<input type='hidden' name='data' value='${tarefa.data}'>
<input type='hidden' name='anotacao' value='${tarefa.anotacao}'>
<input type='submit' value='EDITAR'>
</form>
</td>
</tr>
</c:forEach>
</table>

<button onclick="window.location.href='Login'">Sair</button>


</body>
</html>