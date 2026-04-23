package org.huellasanas;

import org.huellasanas.config.DbConfig;
import org.huellasanas.config.Dbinit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("Conexión: " + DbConfig.getConnection() + " exitosa");

/*
        try (Connection conn = DbConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(
                    "SELECT name FROM sqlite_master WHERE type='table';"
            );

            System.out.println("Tablas en la BD:");

            while (rs.next()) {
                System.out.println("- " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
 */
    }
}