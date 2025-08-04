package com.frutariaapp;

import com.frutariaapp.view.Atendente;
import com.frutariaapp.service.Estoque;

public class Frutaria {

	public static void main(String[] args) {

		System.out.println("🍎🥬 FRUTARIA APP 🥬🍎\n");

		Atendente atendente = new Atendente();
		Estoque estoque = new Estoque();
		int opcaoMenu = 0;

		do {
			opcaoMenu = atendente.menuPrincipal();
			estoque.gerenciarEstoque(opcaoMenu, atendente);
		} while (opcaoMenu != 8);

		System.out.println("\n🎉 Aplicação encerrada! Obrigado por usar o FrutariaApp! 🎉");
	}
}