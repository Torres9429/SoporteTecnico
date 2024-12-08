package utez.edu.mx.SoporteTecnico.model;

public class Ticket {
    private int id;
    private String fecha;
    private Problema problema;
    private Tecnico tecnico;

    public Ticket(int id, String fecha, Problema problema, Tecnico tecnico) {
        this.id = id;
        this.fecha = fecha;
        this.problema = problema;
        this.tecnico = tecnico;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Problema getProblema() {
        return problema;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", Fecha: " + fecha + ", Problema: " + problema + ", Técnico: " + tecnico.getNombre();
    }
}
