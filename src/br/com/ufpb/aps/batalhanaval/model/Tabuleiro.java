package br.com.ufpb.aps.batalhanaval.model;

/* Classe é o tabuleiro do jogo
 * 
 */

public class Tabuleiro {

	private ElementoDeTabuleiro[][] tabuleiro; // inicio um tabuleiro
												// bidimensional

	public Tabuleiro(int alt, int larg) {
		this.tabuleiro = new ElementoDeTabuleiro[alt][larg]; // instancio o
																// tabuleiro

		preencherTabuleiro(); // preencho o tabuleiro
	}

	public String atirar(int x, int y) { // atiro
		String tiro;
		if (x < 0 || x > 14 && y < 0 || y > 14) { // teste se as coordenadas
													// informadas sao validas
			tiro = "JOGADA INVALIDA";
		} else if (tabuleiro[x][y] == null) { // testa se a casa ja levou um
												// tiro
			tiro = "TIRO JÁ EXECUTADO";
		} else { // executa o tiro
			tiro = tabuleiro[x][y].receberTiro();  
			tabuleiro[x][y] = null;  // deixa a casa nula apos o tiro
		}
		return tiro;
	}

	public void addEmbarcacao(Embarcacao e, int x1, int y1, int x2, int y2) {  // adiciona a embarcação nas coordenadas
		if (x1 < x2) {  // caso a embarcação se encontre no eixo y
			for (int i = x1; i < x2 + 1; i++) {
				tabuleiro[y1][i] = e;
			}
		} else {  // caso a embarcação se encontre no eixo x
			for (int i = y1; i < y2 + 1; i++) {
				tabuleiro[i][x1] = e;
			}
		}
	}

	
	private void preencherTabuleiro() {  // preenche o tabuleiro com agua
		for (ElementoDeTabuleiro[] e : tabuleiro) {
			for (int i = 0; i < e.length; i++) {
				e[i] = new Agua();
			}
		}
	}

}
