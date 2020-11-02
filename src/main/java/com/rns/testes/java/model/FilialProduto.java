package com.rns.testes.java.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "FILIAL_PRODUTO")
@Data
public class FilialProduto extends GenericEntity<FilialProdutoId>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 789997049157345794L;
	
	@EmbeddedId
	private FilialProdutoId id;

	@Column
	private Long quantidade;

}
