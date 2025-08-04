package com.frutariaapp.view;

import java.util.Scanner;

public class Atendente {

	private Scanner sc;

	public Atendente() {
		sc = new Scanner(System.in);
	}

	public int menuPrincipal() {
		System.out.println("=================== Quitanda Bananal ===================\n");
		System.out.println("-------------------------------------------------------- \n");

		System.out.println("1 - Cadastrar Fruta \n2 - Listar Frutas \n3 - Remover Fruta \n");
		System.out.println("--------------------------------------------------------");
		System.out.println("\n4 - Cadastrar Verdura \n5 - Listar Verduras \n6 - Remover Verdura \n");
		System.out.println("--------------------------------------------------------");
		System.out.println("\n7 - Listar TODOS os Produtos (Polimorfismo!) \n");
		System.out.println("--------------------------------------------------------");
		System.out.println("\n8 - Sair da Quitanda \n");
		System.out.println("-------------------------------------------------------- \n");
		int menu = sc.nextInt();
		System.out.println("\n========================================================");
		sc.nextLine();
		return menu;
	}


	public String cadastrarNomeProduto(String tipoProduto) {
		System.out.print("\nDigite o nome da " + tipoProduto + ": ");
		String nome = sc.nextLine();
		return nome;
	}

	public double cadastrarPrecoProduto(String tipoProduto) {
		System.out.print("Digite o preço da " + tipoProduto + ": ");
		double preco = sc.nextDouble();
		sc.nextLine();
		return preco;
	}

	public int cadastrarQuantidadeProduto(String tipoProduto) {
		System.out.print("Digite a quantidade da " + tipoProduto + ": ");
		int quantidade = sc.nextInt();
		sc.nextLine();
		return quantidade;
	}


	public double cadastrarPesoFruta() {
		System.out.print("Digite o peso da fruta (kg): ");
		double peso = sc.nextDouble();
		sc.nextLine();
		return peso;
	}

	public String cadastrarTipoVerdura() {
		System.out.print("Digite o tipo da verdura: ");
		String tipo = sc.nextLine();
		return tipo;
	}


	public String removerProduto(String tipoProduto) {
		System.out.print("\nDigite o nome da " + tipoProduto + " a ser removida: ");
		String remover = sc.nextLine();
		return remover;
	}

	public void visualizarProdutoRemovido(String nome, String tipoProduto) {
		System.out.println("\nA " + tipoProduto + " '" + nome + "' foi removida.\n");
	}

	public void mensagemProdutoNaoEncontrado(String tipoProduto) {
		System.out.println("\n" + tipoProduto.substring(0, 1).toUpperCase() +
				tipoProduto.substring(1) + " não encontrada.\n");
	}


	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}
}