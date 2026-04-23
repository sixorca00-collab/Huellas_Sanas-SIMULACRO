package org.huellasanas.models;

import java.time.LocalDateTime;

public class Cita {

    private int id;
    private LocalDateTime fechaHora;
    private int mascotaId;
    private String veterinarioId;
    private String motivo;

    // Constructor completo
    public Cita(int id, LocalDateTime fechaHora, int mascotaId, String veterinarioId, String motivo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.motivo = motivo;
    }

    // Constructor sin ID (para inserts)
    public Cita(LocalDateTime fechaHora, int mascotaId, String veterinarioId, String motivo) {
        this.fechaHora = fechaHora;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.motivo = motivo;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public String getVeterinarioId() {
        return veterinarioId;
    }

    public String getMotivo() {
        return motivo;
    }

    // SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public void setVeterinarioId(String veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}