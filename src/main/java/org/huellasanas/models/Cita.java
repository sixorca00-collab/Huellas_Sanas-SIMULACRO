package org.huellasanas.models;

public class Cita {

    private int id;
    private String fecha;
    private String hora;
    private int mascotaId;
    private String veterinarioId;
    private String motivo;

    public Cita(int id, String fecha, String hora, int mascotaId, String veterinarioId, String motivo) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.motivo = motivo;
    }

    public Cita(String fecha, String hora, int mascotaId, String veterinarioId, String motivo) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.motivo = motivo;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
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