package br.com.ufpb.aps.batalhanaval.model;

import java.io.IOException;

/* Classe de excess�o para caso o arquivo nao exista
 * 
 */

public class ArquivoInexistenteExcepton extends IOException{
	
	public ArquivoInexistenteExcepton(){
		super("ERROR: ARQUIVO N�O EXISTE");
	}

}
