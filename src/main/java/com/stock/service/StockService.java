package com.stock.service;


import java.util.List;

public interface StockService<T> {
    List<T> getAll();
    T getById(long id);
    T update(long id, T t);
    void delete(long id);
}
