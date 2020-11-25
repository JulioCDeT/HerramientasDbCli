package io.juliocdet.inventario.cli.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionUtils {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/inventario?"
            + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static Connection connection;

    public static Connection getConnection(String user, String password) throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(CONNECTION_URL, user, password);
        }
        return connection;
    }
}
