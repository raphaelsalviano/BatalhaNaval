package br.com.ufpb.aps.batalhanaval.model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BatalhaNavalTxt {

	private BatalhaNavalFacade bnc;
	private Scanner entrada;

	public static void main(String[] args) {
		new BatalhaNavalTxt().iniciarJogo();  // inicia o main
	}

	private void iniciarJogo() {  // método main
		bnc = new BatalhaNavalFacade(); // instancia batalha naval
		entrada = new Scanner(System.in);  // instancia o scanner (entrada de dados pelo teclado)
		String[] diretorios = new String[2];  // Instancia um array de diretorios de arquivo

		for (int i = 0; i < 2; i++) {   // Pede ao jogador o diretorio para o arquivo de embarcações
			System.out.println("Informe o diretório do arquivo\nJ" + (i + 1)
					+ " > ");
			String diretorio = entrada.next();  // captura a entrada do usuario
			diretorios[i] = diretorio;  // adiciona o diretorio no array de diretorios
		}

		try {  // tente
			if (bnc.carregarEmbarcacoesDoArquivo(new File(diretorios[0]), 0) // Verifica se os arquivos existem e se há erros neles
					&& bnc.carregarEmbarcacoesDoArquivo(
							new File(diretorios[1]), 1)) {
				System.out.println("Arquivos carregados com sucesso"); 
			}
		} catch (IOException | CoordenadaInvalidaException e) {
			System.err.printf(e.getMessage());  // Lança a excessão caso ocorra algum problema
		}

		boolean jog1_acertou = true;  // jogador1 inicia
		boolean cont = true; // Contador de rodadas do jogo
		int x = 0;  // coordenada x
		int y = 0;  // coordenada y
		String acertou = null;  // Resultado se acertou a coordenada

		while (cont) {   // Rodadas do jogo

			if (jog1_acertou == true) {   // Se for a vez do jogador1
				System.out.println("J1 > ");
				if (entrada.hasNextInt()) {  // Pega a entrada de coordenadas do jogador 1 (pelo teclado)
					x = (entrada.nextInt()) - 1;  // salva o numero na coordenada x
					y = (entrada.nextInt()) - 1;  // salva o proximo numero da linha na coordenada y
												  // Sempre é decrementado 1 de cada coordenada devido os indices do tabuleiro (array) ir de 0 à 14
					acertou = bnc.atirar(1, x, y);  // executa o tiro na coordenada e recebe um texto como resultado
					if (acertou.equalsIgnoreCase("agua")) { // Caso o jogador1 erre o tiro ele perde a vez e passa apra o proximo
						jog1_acertou = false;
					}
				}
				System.out.println(acertou);   // exibe o que o tiro acertou
			} else {    // inicia a vez do jogador2
				System.out.println("J2 > ");
				if (entrada.hasNextInt()) {  // Pega a entrada de coordenadas do jogador 2 (pelo teclado)
					x = (entrada.nextInt()) - 1;  // salva o numero na coordenada x
					y = (entrada.nextInt()) - 1;  // salva o numero na coordenada y
					// Sempre é decrementado 1 de cada coordenada devido os indices do tabulerio(array) serem de 0 a 14
					acertou = bnc.atirar(0, x, y); // executa o tiro na coordenada e recebe um texto como resultado
					if (acertou.equalsIgnoreCase("agua")) {  // Caso o jogador2 erre o tiro eleperde a vez e volta para o jogador1
						jog1_acertou = true;
					}
				}
				System.out.println(acertou); // exibe o que o tiro acertou

			}

		}

	}

}
