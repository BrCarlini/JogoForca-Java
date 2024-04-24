package br.com.jogoforca;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Instancias
		Scanner scn = new Scanner(System.in);
		Jogo jogo = new Jogo();

		
		// Variaveis
		int opcaoMenu = 0;
		boolean flag = true;

		
		
		
		// Menu
		while (flag) {
			System.out.printf("""
					==========================================
					=========== MENU JOGO DA FORCA ===========
					==========================================

					1 -> Cadastrar Jogador
					2 -> Exibir Jogadores (%d)
					3 -> Jogar
					4 -> Sair

					>>>
							""", jogo.quantidadeDeJogadores());

			opcaoMenu = scn.nextInt();
			
			

			switch (opcaoMenu) {
			
			case 1: 
				
				jogo.cadastraJogador();
				break;
		
			case 2: 

				jogo.exibeStatusJogadores();
				break;
			
			case 3: 
				
				jogo.jogo();
				break;
			
			case 4: 
				
				System.out.println("Jogo encerrado.");
				flag = false;
				break;
			
			default:
				System.out.println("Opção inválida! (Escolha as opções do menu em forma numerica.)");
				
			}
		}

		scn.close();
	}

}
