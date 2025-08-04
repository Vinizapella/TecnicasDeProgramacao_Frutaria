package com.frutariaapp.service;

import java.util.List;
import java.util.ArrayList;

import com.frutariaapp.model.Produto;
import com.frutariaapp.model.Fruta;
import com.frutariaapp.model.Verdura;
import com.frutariaapp.view.Atendente;

public class Estoque {

	private List<Produto> estoqueProdutos;

	public Estoque() {
		estoqueProdutos = new ArrayList<>();
	}

	public void gerenciarEstoque(int opcaoMenu, Atendente atendente) {

		switch(opcaoMenu) {

			case 1 -> cadastrarFruta(atendente);
			case 2 -> listarFrutas();
			case 3 -> removerProduto(atendente, "fruta");
			case 4 -> cadastrarVerdura(atendente);
			case 5 -> listarVerduras();
			case 6 -> removerProduto(atendente, "verdura");
			case 7 -> listarTodosProdutos();
			case 8 -> {
				System.out.println("\nObrigado por confiar na Quitanda Bananal. Volte sempre.");
			}
			default -> {
				System.out.println("\nNúmero inválido. Tente novamente.");
			}
		}
	}

	private void cadastrarFruta(Atendente atendente) {
		String nome = atendente.cadastrarNomeProduto("fruta");
		double preco = atendente.cadastrarPrecoProduto("fruta");
		int quantidade = atendente.cadastrarQuantidadeProduto("fruta");
		double peso = atendente.cadastrarPesoFruta();

		Fruta fruta = new Fruta(nome, preco, quantidade, peso);
		estoqueProdutos.add(fruta); // Polimorfismo em ação!
		System.out.println("\nFruta cadastrada com sucesso!");
		System.out.println("\n========================================================");
	}

	private void cadastrarVerdura(Atendente atendente) {
		String nome = atendente.cadastrarNomeProduto("verdura");
		double preco = atendente.cadastrarPrecoProduto("verdura");
		int quantidade = atendente.cadastrarQuantidadeProduto("verdura");
		String tipo = atendente.cadastrarTipoVerdura();

		Verdura verdura = new Verdura(nome, preco, quantidade, tipo);
		estoqueProdutos.add(verdura); // Polimorfismo em ação!
		System.out.println("\nVerdura cadastrada com sucesso!");
		System.out.println("\n========================================================");
	}

	private void listarFrutas() {
		System.out.println("\n==================== Lista de Frutas ===================\n");
		System.out.println("--------------------------------------------------------");

		boolean encontrouFruta = false;

		for (Produto produto : estoqueProdutos) {
			if (produto instanceof Fruta fruta) {
				System.out.println(fruta);
				encontrouFruta = true;
			}
		}

		if (!encontrouFruta) {
			System.out.println("\nNenhuma fruta cadastrada.\n");
		}
		System.out.println("--------------------------------------------------------\n");
	}

	private void listarVerduras() {
		System.out.println("\n=================== Lista de Verduras ==================\n");
		System.out.println("--------------------------------------------------------");

		boolean encontrouVerdura = false;

		// USANDO INSTANCEOF - Conceito da aula!
		for (Produto produto : estoqueProdutos) {
			if (produto instanceof Verdura verdura) {
				System.out.println(verdura);
				encontrouVerdura = true;
			}
		}

		if (!encontrouVerdura) {
			System.out.println("\nNenhuma verdura cadastrada.\n");
		}
		System.out.println("--------------------------------------------------------\n");
	}

	private void listarTodosProdutos() {
		System.out.println("\n================= Lista de Todos os Produtos ================\n");
		System.out.println("---------------------------------------------------------------");

		if (estoqueProdutos.isEmpty()) {
			System.out.println("\nNenhum produto cadastrado.\n");
		} else {
			for (Produto produto : estoqueProdutos) {
				System.out.println(produto);
			}
		}
		System.out.println("---------------------------------------------------------------\n");
	}

	private void removerProduto(Atendente atendente, String tipoProduto) {
		String nome = atendente.removerProduto(tipoProduto);
		boolean removido = false;

		for (int indice = 0; indice < estoqueProdutos.size(); indice++) {
			Produto produto = estoqueProdutos.get(indice);

			boolean tipoCorreto = (tipoProduto.equals("fruta") && produto instanceof Fruta) ||
					(tipoProduto.equals("verdura") && produto instanceof Verdura);

			if (tipoCorreto && produto.getNome().equalsIgnoreCase(nome)) {
				estoqueProdutos.remove(indice);
				removido = true;
				break;
			}
		}

		if (removido) {
			atendente.visualizarProdutoRemovido(nome, tipoProduto);
		} else {
			atendente.mensagemProdutoNaoEncontrado(tipoProduto);
		}
	}

	public List<Produto> getEstoqueProdutos(){
		return estoqueProdutos;
	}

	public void setEstoqueProdutos(List<Produto> estoqueProdutos){
		this.estoqueProdutos = estoqueProdutos;
	}
}