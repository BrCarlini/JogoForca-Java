package br.com.jogoforca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

	private static Scanner scn = new Scanner(System.in);

	private List<Jogador> jogadores = new ArrayList<>();
	Jogador jogador = new Jogador();
	public String palavra = "marte";
	public char[] palavraFormada = {'_', '_' ,'_' ,'_' ,'_'};
	
	

	public int quantidadeDeJogadores() {
		return jogadores.size();
	}

	public boolean validaVidaDosJogadores() {
		List<Integer> vidaDosJogadores = new ArrayList<>();

		// Adiciona todas as vidas dos jogadores cadastrados
		for (Jogador jogador : jogadores) {
			vidaDosJogadores.add(jogador.getVida());
		}

		for (Integer vida : vidaDosJogadores) {

			if (vida != 0) {
				return true;
			} else {
				return false;
			}
		}

		return false;

	}

	public boolean validaLetra(char letraUsuario) {
		boolean existeLetra = false;

		for (int i = 0; i < palavra.length(); i++) {
			char c = palavra.charAt(i);

			if (c == letraUsuario) {
				existeLetra = true;
				break;
			} else {
				existeLetra = false;
			}
		}

		return existeLetra;
	}

	
	
	public void jogo() {

		String letraUsuarioString = "";
		char letraUsuarioChar;
		boolean flag = validaVidaDosJogadores();

		

		do {

			try {
				for (Jogador jogador : jogadores) {
					System.out.printf("""
							==========================================
							======= ADIVINHE A PALAVRA OCULTA ========
							==========================================

							Dica: A palavra tem %d caracteres \n
							""", this.palavra.length());
					
					System.out.print("PALAVRA: ");
					for(int i = 0; i < palavraFormada.length; i++) {
						System.out.print(palavraFormada[i] + " ");
					}
					System.out.println();

					System.out.println("------------------------------------------");
					System.out.println("Vez do jogador: " + jogador.getNome());
					
					
					
					
					System.out.print("Informe alguma letra: ");
					letraUsuarioString = scn.next().trim().toLowerCase();
					letraUsuarioChar = letraUsuarioString.charAt(0);
					
					

					
					if (validaLetra(letraUsuarioChar)) {
						System.out.printf("A letra %s existe ? %s\n", letraUsuarioChar, validaLetra(letraUsuarioChar));
						for(int i = 0; i < palavra.length(); i++) {
							palavraFormada[palavra.indexOf(letraUsuarioChar)] = letraUsuarioChar;
						}

					} else {
						System.out.printf("A letra %s existe ? %s\n", letraUsuarioChar, validaLetra(letraUsuarioChar));
						jogador.setVida();

					}
					
					
					exibeStatusJogadores();
					
					
					
					
					if (jogador.getVida() == 0) {
						System.out.printf("JOGADOR ELIMINADO: %s\n", jogador.getNome());
						jogadores.remove(jogador);
						
						if(jogadores.size() == 0) {
							System.out.println("""
									==========================================
									=============== GAME OVER ================
									==========================================
									
									
									
									""");
							flag = false;
						}
					}
					
					/*
					System.out.println("Palavra do Array: " + palavraFormadaString);
					System.out.println("Palavra String: " + palavra);
					System.out.println(palavraFormadaString.equals(palavra));
					*/

					String palavraFormadaString = new String(palavraFormada);
					
					if (palavraFormadaString.equals(palavra)) {
						System.out.printf("""
								==========================================
								================ VENCEDOR ================
								================= %s =================
								==========================================
								
								
								
								""", jogador.getNome());
						jogadores.clear();
						flag = false;
					}

				}

			} catch (Exception e) {
				// System.out.println("GAME OVER");
			}
			

		} while (flag);

	}

	public void cadastraJogador() {
		String nomeNovoJogador;
		String confirmaNovoJogador;

		System.out.print("Informe o nome do jogador: ");
		// scn.nextLine();
		// scn.useDelimiter("\n");
		nomeNovoJogador = scn.next();

		// Confirma se realmente quer adicionar novo jogador
		System.out.print("Deseja confirmar o jogador " + nomeNovoJogador + " ? (S/N) ");
		confirmaNovoJogador = scn.next().toLowerCase().trim();

		// Adiciona jogador caso a condição for verdadeira
		if (confirmaNovoJogador.equals("s")) {
			Jogador jogador = new Jogador(nomeNovoJogador);
			jogadores.add(jogador);
			System.out.println("Jogador " + jogador.getNome() + " adicionado!");
		} else {
			System.out.println("Operação Cancelada");
		}

	}

	// Exibe o status dos jogadores (Nome e quantidade de vida)
	public void exibeStatusJogadores() {
		System.out.println("""
				==========================================
				================ JOGADORES ===============
						""");
		for (Jogador jogador : jogadores) {
			System.out.println("------------------------------------------");
			System.out.println("Nome: " + jogador.getNome() + "\nVida: ");
			desenhaForca(jogador.getVida());
			
		}
	}

	public void desenhaForca(int vida) {

		switch (vida) {

		case 4:
			System.out.println("""
					 ____
					|
					|
					|
					|
					|
					
					""");

			break;

		case 3:
			System.out.println("""
					 ____
					|   0
					|
					|
					|
					|
					
					""");

			break;

		case 2:
			System.out.println("""
					 ____
					|   0
					|   |
					|   |
					|
					|
					
					""");

			break;

		case 1:
			System.out.println("""
					 ____
					|   0
					|  /|\\
					|   |
					|
					|
					
					""");

			break;
			
		case 0:
			System.out.println("""
					 ____
					|   0
					|  /|\\
					|  /|\\
					|
					|
					
					""");

			break;

		}

	}

}
