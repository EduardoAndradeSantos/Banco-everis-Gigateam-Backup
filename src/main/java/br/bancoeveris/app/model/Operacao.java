package br.bancoeveris.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Operacao extends BaseResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private double valor;

	@ManyToOne
	@JoinColumn(name = "IdContaOrigem")
	private Conta contaO;

	@ManyToOne
	@JoinColumn(name = "IdContaDestino")
	private Conta contaD;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Conta getContaO() {
		return contaO;
	}

	public void setContaO(Conta contaO) {
		this.contaO = contaO;
	}

	public Conta getContaD() {
		return contaD;
	}

	public void setContaD(Conta contaD) {
		this.contaD = contaD;
	}

	

}
