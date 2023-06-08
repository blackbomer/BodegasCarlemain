package org.example;

public class Bota {
    private static final int maxSize = 1500;
    private int id;
    private boolean open;
    private String fechaCrianza; //este dato almacena la fecha de recarga que a su vez es la fecha de inicio de la crianza.
    private int litrosCarga; //se usa solo en la primer carga
    private int litrosDescarga; // se actualiza en base a cada descarga.
    private String tipo;


    //constructores
    public Bota(int id, String fechaCrianza, Integer litrosCarga, String tipo) {
        open = false; //la bota se asume cerrada desde su carga hasta la primera descarga.
        this.id=id;
        this.fechaCrianza = fechaCrianza;
        this.litrosCarga = litrosCarga;
        this.tipo = tipo;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getFechaCrianza() {
        return fechaCrianza;
    }

    public void setFechaCrianza(String fechaCrianza) {
        this.fechaCrianza = fechaCrianza;
    }

    public int getLitrosCarga() {
        return litrosCarga;
    }

    public void setLitrosCarga(int litrosCarga) {
        this.litrosCarga = litrosCarga;
    }

    public int getLitrosDescarga() {
        return litrosDescarga;
    }

    public void setLitrosDescarga(int litrosDescarga) {
        this.litrosDescarga = litrosDescarga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Bota{" +
                "id=" + id +
                ", open=" + open +
                ", fechaCrianza='" + fechaCrianza + '\'' +
                ", litrosCarga=" + litrosCarga +
                ", litrosDescarga=" + litrosDescarga +
                ", tipo='" + tipo + '\'' +
                '}'+
                "\n";
    }
}
