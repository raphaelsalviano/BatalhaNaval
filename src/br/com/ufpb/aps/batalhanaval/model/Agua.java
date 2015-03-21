package br.com.ufpb.aps.batalhanaval.model;

/* Classe Agua que é um Elemento de Tabuleiro
 * 
 */

public class Agua implements ElementoDeTabuleiro {

	private final String nome = "AGUA";  // possui um nome

	@Override
	public String receberTiro() {  // receb um tiro
		return "AGUA";
	}

	@Override
	public String getNome() {  // pega o nome
		return nome;
	}

}
