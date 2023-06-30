package br.edu.ifsuldeminas.mch.webii.crudmanager.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="jogadores")
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Nome não pode ser vazio" )
    private String nome;
	@NotNull(message = "Number Camisa não pode ser vazio" )
   private int numberCamisa;
   @NotBlank(message = "Campeonato não pode ser vazio" )
   private String campeonato;
   @NotBlank(message = "Posição não pode ser vazio" )
   private String posicao;
    
    @ManyToOne
    @JoinColumn(name="time_id", nullable = false)
    private Time time;
	
	public Jogador() {};
	
	public Jogador(Integer id)
	{
		this.id = id;
		setNome("");
		setNumberCamisa(0);
		setCampeonato("");
		setPosicao("");
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

	public int getNumberCamisa() {
		return numberCamisa;
	}

	public void setNumberCamisa(int numberCamisa) {
		this.numberCamisa = numberCamisa;
	}

	public String getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(String campeonato) {
		this.campeonato = campeonato;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
