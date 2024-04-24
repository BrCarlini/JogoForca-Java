package br.com.jogoforca;

public class Jogador {

	private String nome;
	private int vida;
	
	Jogador(){
		
	}

	Jogador(String nome) {
		this.setNome(nome);
		this.vida = 4;
	}

	public int getVida() {
		return vida;
	}

	public void setVida() {
		this.vida--;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
