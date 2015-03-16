package br.com.ufpb.aps.batalhanaval.model;

public class Embarcacao implements ElementoDeTabuleiro {

	private String nome;
	private int life;

	public Embarcacao(String nome, int life) {
		this.nome = nome;
		this.life = life;
	}

	@Override
	public String receberTiro() {
		life--;
		return life == 0 ? "AFUNDOU" + this.nome : "ACERTOU";
	}

	@Override
	public String getNome() {
		return nome;
	}

}
