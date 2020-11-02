package com.rns.testes.java.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;

import lombok.Data;

/**
 * Esta entidade representa o escopo m?nimo de uma entidade, portanto toda classe entidade deve herda-la.
 */
@Data
@MappedSuperclass
public abstract class GenericEntity<T extends Serializable> implements Serializable, Persistable<T> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 609475431476186573L;

	/**
     * Atributo auto-gerado em cada opera??o realizada pela DAO. Indica quantas vezes o objeto foi manipulado.
     */
    @Version
    @Column(name = "VERSAO", unique = false, nullable = false, precision = 10)
    protected Long versao;

    /**
     * Atributo auto-gerado em cada opera??o realizada pela DAO.
     */
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ULT_ALTERACAO", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date dataUltAlteracao;

    public boolean isNew() {
        return null == getId();
    }

}
