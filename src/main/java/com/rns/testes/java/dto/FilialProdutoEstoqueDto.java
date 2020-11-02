package com.rns.testes.java.dto;

import lombok.Data;

@Data
public class FilialProdutoEstoqueDto {
	
	private Long idFilialOrigem;
	private Long idFilialDestino;
	private Long idProduto;
	private Long quantTroca;
}
