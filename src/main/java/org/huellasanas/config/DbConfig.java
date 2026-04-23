package org.huellasanas.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConfig {
    private static Properties properties = new Properties();
    private static Connection connection;

    static {
        try(InputStream input = DbConfig.class.getClassLoader()
                .getResourceAsStream("db.properties")){
            if (input == null){
                throw new RuntimeException("No se encontró el archivo db.properties");
            }

            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        if (connection == null){
            try{
                String url = properties.getProperty("db.url");
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
