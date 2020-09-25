<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar</title>
</head>
<body>
<form action="Edita" method='post'>
Nome: <input type='text' name='nome' value='${param.nome}'><br>
Matéria: <input type='text' name='materia' value='${param.materia}'><br>
Tarefa: <input type='text' name='tarefa' value='${param.tarefa}'><br>
Data de Entrega: <input type='text' name='data' value='${param.data}'><br>
Anotações: <input type='text' name='anotacao' value='${param.anotacao}'><br>
<input type='hidden' name='id' value='${param.id}'>
<input type='submit' value='ATUALIZAR'>
</form>


</body>
</html>