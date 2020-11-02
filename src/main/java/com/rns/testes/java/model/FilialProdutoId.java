package com.rns.testes.java.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class FilialProdutoId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9124255067345192132L;

	private Long idFilial;
	
	
	private Long idProduto;
	
	public FilialProdutoId(Long idFilial, Long idProduto){
		this.idFilial = idFilial; 
		this.idProduto = idProduto;
	}

	public FilialProdutoId() {
	}
}
