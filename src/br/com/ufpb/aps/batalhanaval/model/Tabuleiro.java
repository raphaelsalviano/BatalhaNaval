package br.com.ufpb.aps.batalhanaval.model;

public class Tabuleiro {

	private ElementoDeTabuleiro[][] tabuleiro;

	public Tabuleiro(int alt, int larg) {
		this.tabuleiro = new ElementoDeTabuleiro[alt][larg];

		preencherTabuleiro();
	}

	public String atirar(int x, int y) {
		return tabuleiro[x][y].receberTiro();
	}

	public void addEmbarcacao(Embarcacao e, int x1, int y1, int x2, int y2) {
		if (x1 < x2) {
			for (int i = x1; i < x2 + 1; i++) {
				tabuleiro[y1][i] = e;
			}
		} else {
			for (int i = y1; i < y2 + 1; i++) {
				tabuleiro[i][x1] = e;
			}
		}
	}

	public String toString() {
		String s = "";
		for (ElementoDeTabuleiro[] e : tabuleiro) {
			for (ElementoDeTabuleiro p : e) {
				s += p.getNome() + " | ";
			}
			s += "\n";
		}
		return s;
	}

	private void preencherTabuleiro() {
		for (ElementoDeTabuleiro[] e : tabuleiro) {
			for (int i = 0; i < e.length; i++) {
				e[i] = new Agua();
			}
		}
	}

}
