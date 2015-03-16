package br.com.ufpb.aps.batalhanaval.model;

public enum TipoEmbarcacao {

	PORTA_AVIOES(5), DESTROYER(4), CRUZADOR(4), SUBMARINO(3), PATRULHA(2);

	private final int life;

	private TipoEmbarcacao(int life) {
		this.life = life;
	}

	public int getLife() {
		return this.life;
	}

}
