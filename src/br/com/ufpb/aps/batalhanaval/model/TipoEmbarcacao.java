package br.com.ufpb.aps.batalhanaval.model;

/* Classe Tipo de Embarcação que contém pre-definidos todas as embarcações
 * como as vidas de cada uma delas
 * 
 */

public enum TipoEmbarcacao {

	PORTA_AVIOES(5), DESTROYER(4), CRUZADOR(4), SUBMARINO(3), PATRULHA(2);  // embarcações e vidas pre-definidas

	private final int life;

	private TipoEmbarcacao(int life) {  // Construtor privado, onde apenas a propria classe pode instancia-la
		this.life = life;
	}

	public int getLife() {  // pega a vida da embarcação
		return this.life;
	}

}
