package com.frutariaapp.model;

public class Verdura extends Produto {

	private String tipo;

	public Verdura(String nome, double preco, int quantidade, String tipo) {
		super(nome, preco, quantidade);
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Verdura [nome=" + nome + ", preco=R$" + preco + ", quantidade=" + quantidade + ", tipo=" + tipo + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}