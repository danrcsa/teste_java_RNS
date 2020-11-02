package com.rns.testes.java.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;

/**
 * Interface representa os m?todos m?nimos que devem ser criados nas services dessa API.
 *
 * @param <T> Entidade que a service ser? respons?vel.
 * @param <I> A classe do id da entidade.
 */
public interface IGenericService<T, I extends Serializable> {

    T save(T t);

    List<T> findAll();

    T findById(I i);

    T update(T t);

    void delete(T t);

    void delete(I i);

	List<T> findAllById(Iterable<I> ids);
    
}
