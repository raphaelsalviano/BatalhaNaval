package br.com.ufpb.aps.batalhanaval.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BatalhaNaval {

	private final int QUANT_TAB = 2; // Quantidade de jogadores
	private final int ALTURA = 15; // Altura do tabuleiro
	private final int LARGURA = 15; // Largura do tabuleiro

	private Tabuleiro[] tabuleiros; // Array com os tabuleiros

	public BatalhaNaval() { // Construtor da classe
		tabuleiros = new Tabuleiro[QUANT_TAB]; // Inicializa o array de
												// tabuleiros com um new
		for (int i = 0; i < tabuleiros.length; i++) { // Roda a quantidade de
														// jogadores existentes
			tabuleiros[i] = new Tabuleiro(ALTURA, LARGURA); // Instancia um
															// tabuleiro para
															// cada jogador
															// (rodada do for)
		}
	}

	public Tabuleiro[] getTabuleiros() { // Pegar a lista de tabuleiros
		return tabuleiros;
	}

	/*
	 * Método que carrega as embarcações por meio de arquivo
	 */
	public boolean carregarEmbarcacoesDoArquivo(File arq, int tab)
			throws ArquivoInexistenteExcepton, IOException,
			CoordenadaInvalidaException { // Excessões do
		// método
		boolean embarcacao_jog = false; // Retorno do método para saber se
										// carregou as embarcações
		String lendo; // String que guarda a linha
		boolean cont = true; // Variavel que controla a leitura das linhas
		if (arq.exists()) { // Verifica se o caminho do arquivo existe
			FileReader reader = new FileReader(arq.getAbsolutePath()); // Carrego
																		// o
																		// arquivo
			BufferedReader buffer = new BufferedReader(reader); // Carrego o
																// arquivo para
																// a memoria
			int linha = 1;

			/*
			 * Laço while serve para ler todas as linhas existentes no arquivo
			 */

			while (cont) {
				lendo = buffer.readLine(); // Pega a linha do arquivo
				carregarEmbarcacaoTabuleiro(lendo, tab, linha, arq);
				// Chama os métodos necessários para carregar a embarcação

				linha++;
				if (lendo == null) { // Caso o valor da linha seja nulo
					cont = false; // Ele altera o valor de cont para encerrar o
									// laço while e parar de ler o arquivo
				}
			}
			embarcacao_jog = true; // altera o valor para saber se foi
									// lido/carregado com sucesso
		} else {
			throw new ArquivoInexistenteExcepton(); // Caso o caminho do arquivo
													// do arquivo esteja errado
													// ou ele não exista
		} // Ele retorna uma excessão
		return embarcacao_jog; // retorna se o carregamento/leitura ocorreu com
								// sucesso
	}

	/*
	 * Método privado que carrega a embarcação para o tabuleiro Recebe uma linha
	 * de codigo do arquivo e um indice de tabuleiro
	 */

	private void carregarEmbarcacaoTabuleiro(String embarcacao, int tab,
			int linha, File arq) throws CoordenadaInvalidaException {
		if (embarcacao != null) { // Verifica se a linha é nula
			String[] l = embarcacao.split(" "); // Separa a string em um array
												// de palavras
			Embarcacao e = criarEmbarcacao(l); // Cria a embarcação
			int[] i = carregarCoordenadas(l, linha, arq); // Pega as coordenadas do
														// arquivo da embarcação
			tabuleiros[tab].addEmbarcacao(e, i[0], i[1], i[2], i[3]); // Adiciona
																		// embarcação
																		// ao
																		// tabuleiro
		}

	}

	/*
	 * Método que cria a embarcação utilizando o nome que estava no arquivo
	 */

	private Embarcacao criarEmbarcacao(String[] l) {
		Embarcacao e;
		if (l[0].equalsIgnoreCase(TipoEmbarcacao.PORTA_AVIOES.name())) { // Verifica
																			// se
																			// o
																			// nome
																			// da
																			// embarcação
																			// é
																			// igual
			e = new Embarcacao(TipoEmbarcacao.PORTA_AVIOES.name(), // as
																	// embarcações
																	// pre
																	// definidas
																	// no jogo
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
		return e; // Retorna a embarcação ja pronta para uso
	}

	/*
	 * Pega as coordenadas que estavam na linha e as converte para tipo de uso
	 * interno do tabuleiro
	 */

	private int[] carregarCoordenadas(String[] l, int linha, File arq)
			throws CoordenadaInvalidaException {
		int[] coordenadas = new int[4]; // Cria um array de coordenadas
		int cont = 0; // Contador para o indice da minha linha do arquivo
		for (int i = 1; i < l.length; i++) { // Percorre a linha do arquivo
												// (esta em formato string)
			int coord = Integer.parseInt(l[i]) - 1; // Converte a coordenada de
													// String para inteiro
			if (coord < 0 && coord > 14) { // Teste se as coordenadas são
											// válidas
				System.err.println("ERRO LINHA " + linha + ": " + arq.getName()); // Lança															// a
																				// excessão
			} else { // Caso seja validas continua com o processo
				coordenadas[cont] = coord;
				cont++; // incrementa o contador
			}
		}
		return coordenadas; // retorna o array de coordenadas
	}

}
