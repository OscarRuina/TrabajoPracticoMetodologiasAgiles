package com.unla.pedidosya.service;

import java.util.Optional;

public interface IGenericService <E>{
    Optional<E> findById(long id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(long id);
}
