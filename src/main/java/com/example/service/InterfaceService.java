package com.example.service;

import java.util.List;

public interface InterfaceService<T> {
    void save(T t);
    List<T> findAll();
    T findById(Long id);
    void delete(Long id);
}
