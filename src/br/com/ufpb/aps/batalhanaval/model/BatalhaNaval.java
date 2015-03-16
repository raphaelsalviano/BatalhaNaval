package br.com.ufpb.aps.batalhanaval.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BatalhaNaval {

	private final int QUANT_TAB = 2;
	private final int ALTURA = 15;
	private final int LARGURA = 15;

	private Tabuleiro[] tabuleiros;

	public BatalhaNaval() {
		tabuleiros = new Tabuleiro[QUANT_TAB];
		for (int i = 0; i < tabuleiros.length; i++) {
			tabuleiros[i] = new Tabuleiro(ALTURA, LARGURA);
		}
	}

	public Tabuleiro[] getTabuleiros() {
		return tabuleiros;
	}

	public boolean carregarEmbarcacoesDoArquivo(File arq, int tab)
			throws IOException {
		boolean embarcacao_jog = false;
		String lendo;
		boolean cont = true;
		if (arq.exists()) {
			FileReader reader = new FileReader(arq.getAbsolutePath());
			BufferedReader buffer = new BufferedReader(reader);

			while (cont) {
				lendo = buffer.readLine();
				carregarEmbarcacaoTabuleiro(lendo, tab);
				if (lendo == null) {
					cont = false;
				}
			}
			embarcacao_jog = true;
		}else{
			throw new IOException();
		}
		return embarcacao_jog;
	}

	private void carregarEmbarcacaoTabuleiro(String embarcacao, int tab) {
		if (embarcacao != null) {
			String[] l = embarcacao.split(" ");
			Embarcacao e = criarEmbarcacao(l);
			int[] i = carregarCoordenadas(l);
			tabuleiros[tab].addEmbarcacao(e, i[0], i[1], i[2], i[3]);
		}

	}

	private Embarcacao criarEmbarcacao(String[] l) {
		Embarcacao e;
		if (l[0].equalsIgnoreCase(TipoEmbarcacao.PORTA_AVIOES.name())) {
			e = new Embarcacao(TipoEmbarcacao.PORTA_AVIOES.name(),
					TipoEmbarcacao.PORTA_AVIOES.getLife());
		} else if (l[0].equalsIgnoreCase(TipoEmbarcacao.CRUZADOR.name())) {
			e = new Embarcacao(TipoEmbarcacao.CRUZADOR.name(),
					TipoEmbarcacao.CRUZADOR.getLife());
		} else if (l[0].equalsIgnoreCase(TipoEmbarcacao.DESTROYER.name())) {
			e = new Embarcacao(TipoEmbarcacao.DESTROYER.name(),
					TipoEmbarcacao.DESTROYER.getLife());
		} else if (l[0].equalsIgnoreCase(TipoEmbarcacao.PATRULHA.name())) {
			e = new Embarcacao(TipoEmbarcacao.PATRULHA.name(),
					TipoEmbarcacao.PATRULHA.getLife());
		} else {
			e = new Embarcacao(TipoEmbarcacao.SUBMARINO.name(),
					TipoEmbarcacao.SUBMARINO.getLife());
		}
		return e;
	}

	private int[] carregarCoordenadas(String[] l) {
		int[] coord = new int[4];
		int cont = 0;
		for (int i = 1; i < l.length; i++) {
			coord[cont] = Integer.parseInt(l[i]);
			cont++;
		}
		return coord;
	}

}
