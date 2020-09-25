package br.edu.insper.mvc.model;


import java.util.Calendar;

public class Tarefas {
	private Integer id;
	private String nome;
	private String materia;
	private String tarefa;
	private Calendar data;
	private String anotacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

}
