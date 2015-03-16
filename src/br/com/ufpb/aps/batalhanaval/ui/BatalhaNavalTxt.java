package br.com.ufpb.aps.batalhanaval.ui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import br.com.ufpb.aps.batalhanaval.controller.BatalhaNavalController;

public class BatalhaNavalTxt {

	private BatalhaNavalController bnc;
	private Scanner entrada;

	public static void main(String[] args) {
		new BatalhaNavalTxt().iniciarJogo();
	}

	private void iniciarJogo() {
		bnc = new BatalhaNavalController();
		entrada = new Scanner(System.in);
		String[] diretorios = new String[2];

		for (int i = 0; i < 2; i++) {
			System.out.println("Informe o diretório do arquivo\nJ" + (i + 1)
					+ " > ");
			String diretorio = entrada.nextLine();
			diretorios[i] = diretorio;
		}

		try {
			if (bnc.carregarEmbarcacoesDoArquivo(new File(diretorios[0]), 0)
					&& bnc.carregarEmbarcacoesDoArquivo(
							new File(diretorios[1]), 1)) {
				System.out.println("Arquivos carregados com sucesso");
			}
		} catch (IOException e) {
			System.err.printf("Erro no arquivo %s. \n", e.getMessage());
		}

		boolean jog1_acertou = true;
		int x = 0;
		int y = 0;

		do {

			if (jog1_acertou == true) {
				System.out.println("J1 > ");
				if (entrada.hasNextInt()) {
					x = entrada.nextInt();
					y = entrada.nextInt();
				}
				String acertou = bnc.atirar(1, x, y);
				if (acertou.equalsIgnoreCase("agua")) {
					jog1_acertou = false;
				}
				System.out.println(acertou);
			} else {
				System.out.println("J2 > ");
				if (entrada.hasNextInt()) {
					x = entrada.nextInt();
					y = entrada.nextInt();
				}
				String acertou = bnc.atirar(0, x, y);
				if (acertou.equalsIgnoreCase("agua")) {
					jog1_acertou = true;
				}
				System.out.println(acertou);

			}

		} while (true);

	}

}
