package br.com.ufpb.aps.batalhanaval.model;

/* Classe embarcação que é um elemento de tabuleiro
 * 
 */

public class Embarcacao implements ElementoDeTabuleiro {

	private String nome;  // possui um nome
	private int life;  // possui uma certa quantidade de vidas

	public Embarcacao(String nome, int life) {  // construtor
		this.nome = nome;
		this.life = life;
	}

	@Override
	public String receberTiro() {  // recebe um tiro
		life--;  // decrementa a vida caso receba um tiro
		return life == 0 ? "AFUNDOU" + this.nome : "ACERTOU";  // retorna se acertou a embarcação ou se afundou quando as vidas acabarem
	}

	@Override
	public String getNome() {  // pega o nome
		return nome;
	}
	
	public int getLife(){  // pega a vida
		return life;
	}

}
