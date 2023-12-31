package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="times")
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Nome não pode ser vazio" )
	private String nome;
	@NotBlank(message = "Liga não pode ser vazio" )
	private String liga;
	@NotBlank(message = "Tecnico não pode ser vazio" )
	private String tecnico;
	private Boolean titulos;

	public Time() {};
	
	public Time(Integer id)
	{
		this.id = id;
		setNome("");
		setLiga("");
		setTecnico("");
		setTitulos(true);
	}

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

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public Boolean getTitulos() {
		return titulos;
	}

	public void setTitulos(Boolean titulos) {
		this.titulos = titulos;
	}
	
}
