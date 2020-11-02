package com.rns.testes.java.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Getter
public enum EnumTipoFilial {

    DEPOSITO(1,"Deposito"),
    LOJA_PF(2,"Loja - BtoC"), 
    LOJA_PJ(3,"Loja - BtoB");
	
	private Integer num;
    private String descricao;

    EnumTipoFilial(Integer num, String descricao) {
    	this.num = num;
        this.descricao = descricao;
    }

    public static List<EnumTipoFilial> getAll() {
        return new ArrayList<>(EnumSet.allOf(EnumTipoFilial.class));
    }
    
    public static EnumTipoFilial findByNum(Integer num){
    	for (EnumTipoFilial e : EnumTipoFilial.values()) {
    		if(e.getNum() == num){
    			return e;
    		}
    	}
    	return null;
    }
    
}
