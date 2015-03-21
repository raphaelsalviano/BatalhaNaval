package br.com.ufpb.aps.batalhanaval.model;

/* Classe Tipo de Embarca��o que cont�m pre-definidos todas as embarca��es
 * como as vidas de cada uma delas
 * 
 */

public enum TipoEmbarcacao {

	PORTA_AVIOES(5), DESTROYER(4), CRUZADOR(4), SUBMARINO(3), PATRULHA(2);  // embarca��es e vidas pre-definidas

	private final int life;

	private TipoEmbarcacao(int life) {  // Construtor privado, onde apenas a propria classe pode instancia-la
		this.life = life;
	}

	public int getLife() {  // pega a vida da embarca��o
		return this.life;
	}

}
