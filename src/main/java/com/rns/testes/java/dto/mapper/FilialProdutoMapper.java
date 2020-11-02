package com.rns.testes.java.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rns.testes.java.dto.FilialProdutoDto;
import com.rns.testes.java.model.FilialProduto;

@Mapper
public interface FilialProdutoMapper extends GenericMapper<FilialProduto, FilialProdutoDto> {

    FilialProdutoMapper INSTANCE = Mappers.getMapper(FilialProdutoMapper.class);

}
