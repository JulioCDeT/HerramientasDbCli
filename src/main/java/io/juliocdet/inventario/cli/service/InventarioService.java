package io.juliocdet.inventario.cli.service;

import io.juliocdet.inventario.cli.exception.DaoException;
import io.juliocdet.inventario.cli.exception.InventarioServiceException;
import io.juliocdet.inventario.cli.model.Herramienta;
import io.juliocdet.inventario.cli.repository.HerramientasDao;
import io.juliocdet.inventario.cli.util.DataBaseConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class InventarioService {

    private Connection dbConnection;
    private HerramientasDao herramientasDao;

    public InventarioService(String user, String password) throws InventarioServiceException {

        try {
            dbConnection = DataBaseConnectionUtils.getConnection(user, password);
            herramientasDao = new HerramientasDao(dbConnection);
        } catch (SQLException throwables) {
            throw new InventarioServiceException("Fail while getting database connections");
        }
    }

    public void getAllTools() {
        try {
            herramientasDao.getAll().forEach(System.out::println);
        } catch (DaoException e) {
            e.printStackTrace(System.out);
        }
    }

    public void getAllToolById(int id) {
        try {
            Herramienta herramienta = herramientasDao.get(new Herramienta(id));
            System.out.println(herramienta);
        } catch (DaoException e) {
            e.printStackTrace(System.out);
        }
    }

    public void addHerramienta(Herramienta herramienta) {
        try {
            herramientasDao.add(herramienta);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
