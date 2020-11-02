package com.rns.testes.java.dto;

import com.rns.testes.java.model.GenericEntity;

import lombok.Data;

@Data
public class FilialProdutoDto extends GenericEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -550351139909996848L;
	private Long id;
	private ProdutoDto produto;
	private FilialDto filial;
}
