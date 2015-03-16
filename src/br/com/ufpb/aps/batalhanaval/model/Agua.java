package br.com.ufpb.aps.batalhanaval.model;

public class Agua implements ElementoDeTabuleiro {

	private final String nome = "AGUA";

	@Override
	public String receberTiro() {
		return "AGUA";
	}

	@Override
	public String getNome() {
		return nome;
	}

}
