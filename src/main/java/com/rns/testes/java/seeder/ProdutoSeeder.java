package com.rns.testes.java.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rns.testes.java.model.Produto;
import com.rns.testes.java.repository.ProdutoRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProdutoSeeder {

    @Autowired
    ProdutoRepository repository;

    @EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando produtos....");
            criandoFiliais();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void criandoFiliais() {
        for (Long i = 1L; i < 25; i++) {
            Produto produto = new Produto();
            produto.setId(i);
            produto.setNome("Sal produto " + i);
            repository.save(produto);
        }
    }
}
