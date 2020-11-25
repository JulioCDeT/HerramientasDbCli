package io.juliocdet.inventario.cli.repository;

import io.juliocdet.inventario.cli.exception.DaoException;

import java.util.List;

public interface Dao<T> {
    List<T> getAll() throws DaoException;
    T get(T item) throws DaoException;
    boolean add(T item) throws DaoException;
    boolean delete(T item) throws DaoException;
    boolean update(T currectItem, T newItem) throws DaoException;
}