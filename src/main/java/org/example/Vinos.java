package org.example;

public class Vinos {
    private String variedad;
    private String origen;
    private int anoCosecha;

    public Vino(String variedad, String origen, int anoCosecha) {
        this.variedad = variedad;
        this.origen = origen;
        this.anoCosecha = anoCosecha;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getAnoCosecha() {
        return anoCosecha;
    }

    public void setAnoCosecha(int anoCosecha) {
        this.anoCosecha = anoCosecha;
    }

    public String toString() {
        return "Variedad: " + variedad + ", Origen: " + origen + ", Año de Cosecha: " + anoCosecha;
    }
}
