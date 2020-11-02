package com.rns.testes.java.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rns.testes.java.dto.FilialDto;
import com.rns.testes.java.dto.mapper.FilialMapper;
import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.repository.FilialRepository;

@CrossOrigin
@RestController
@RequestMapping
public class FilialController {

    private static final String BASE_URL = "filial/";

    @Autowired
    FilialRepository repository;
    
    @GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Filial>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    // retorno com erro caso não encontre
    @GetMapping(value = BASE_URL + "find-by-id", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Optional<Filial>> findById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @PutMapping(value = BASE_URL + "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Filial> update(@RequestBody FilialDto dto) {
        return ResponseEntity.ok(repository.save(FilialMapper.INSTANCE.dtoToEntity(dto)));
    }

    //validar 
    @PostMapping(value = BASE_URL + "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Filial> insert(@RequestBody FilialDto dto) {
        return ResponseEntity.ok(repository.save(FilialMapper.INSTANCE.dtoToEntity(dto)));
    }

    @DeleteMapping(value = BASE_URL + "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam(name = "id") Long id) {
    	repository.deleteById(id);
    }

    @GetMapping(value = BASE_URL + "type/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<EnumTipoFilial>> findAllEnumTipoFilial() {
        return ResponseEntity.ok(EnumTipoFilial.getAll());
    }
    
    @GetMapping(value = BASE_URL + "type-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> findAllEnumTipoFilialPorNum(
    		@RequestParam(name = "num") Integer num) {
        return ResponseEntity.ok(EnumTipoFilial.findByNum(num).getDescricao());
    }
    
    @GetMapping(value = BASE_URL + "find-all-by-id", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Filial>> findAllById(@RequestParam(name = "id") Long id) {
    	List<Long> ids = new ArrayList<>();
    	ids.add(id);
    	ids.add(2L);
        return ResponseEntity.ok(repository.findAllById(ids));
    }
}
