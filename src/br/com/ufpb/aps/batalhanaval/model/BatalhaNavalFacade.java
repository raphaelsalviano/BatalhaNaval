package br.com.ufpb.aps.batalhanaval.model;

import java.io.File;
import java.io.IOException;

public class BatalhaNavalFacade {

	/*
	 * Facade
	 */

	private BatalhaNaval bn;

	public BatalhaNavalFacade() {
		bn = new BatalhaNaval();
	}

	public boolean carregarEmbarcacoesDoArquivo(File f, int tab)
			throws IOException, ArquivoInexistenteExcepton, CoordenadaInvalidaException {
		return bn.carregarEmbarcacoesDoArquivo(f, tab);
	}

	
	public String atirar(int jog, int x, int y) {
		return bn.getTabuleiros()[jog].atirar(x, y);
	}

	public String exibirTabuleiro(int jog) {
		return bn.getTabuleiros()[jog].toString();
	}

	public void adicionarEmbarcacao(int jog, Embarcacao e, int x1, int y1,
			int x2, int y2) {
		bn.getTabuleiros()[jog].addEmbarcacao(e, x1, y1, x2, y2);
	}

}
