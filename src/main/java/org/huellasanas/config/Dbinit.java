package org.huellasanas.config;

import java.sql.Connection;
import java.sql.Statement;

public class Dbinit {

    public static void init() {

        try (Connection conn = DbConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS cliente (
                    id TEXT PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    telefono TEXT
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS mascotas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    genero TEXT,
                    tipo TEXT,
                    cliente_id TEXT NOT NULL,
                    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
                );
            """);

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS veterinario (
                    id TEXT PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    especialidad TEXT
                );
            """);
            stmt.execute("""
    CREATE TABLE IF NOT EXISTS cita (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        fecha TEXT NOT NULL,
        hora TEXT NOT NULL,
        mascota_id INTEGER NOT NULL,
        veterinario_id TEXT NOT NULL,
        motivo TEXT,

        FOREIGN KEY (mascota_id) REFERENCES mascotas(id),
        FOREIGN KEY (veterinario_id) REFERENCES veterinario(id),

        UNIQUE (fecha, hora, veterinario_id)
    );
""");

            System.out.println("Tablas creadas correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}