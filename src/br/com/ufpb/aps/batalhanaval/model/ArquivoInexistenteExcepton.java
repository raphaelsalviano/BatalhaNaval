package br.com.ufpb.aps.batalhanaval.model;

import java.io.IOException;

/* Classe de excessão para caso o arquivo nao exista
 * 
 */

public class ArquivoInexistenteExcepton extends IOException{
	
	public ArquivoInexistenteExcepton(){
		super("ERROR: ARQUIVO NÃO EXISTE");
	}

}
