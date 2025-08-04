package com.frutariaapp.model;

public class Fruta extends Produto {

	private double peso;

	public Fruta(String nome, double preco, int quantidade, double peso) {
		super(nome, preco, quantidade);
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Fruta [nome=" + nome + ", preco=R$" + preco + ", quantidade=" + quantidade + ", peso=" + peso + "kg]";
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}