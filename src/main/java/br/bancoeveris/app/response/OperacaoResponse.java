package br.bancoeveris.app.response;

import br.bancoeveris.app.model.BaseResponse;

public class OperacaoResponse extends BaseResponse{
	private Long id;
	private double valor;
	private String tipo;
	private String hash;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}

	
}
