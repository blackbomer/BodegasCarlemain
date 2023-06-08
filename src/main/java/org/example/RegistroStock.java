package org.example;

class RegistroStock {
    private String tipoProducto;   // Tipo de producto del stock
    private int cantidad;          // Cantidad en stock

    public RegistroStock(String tipoProducto, int cantidad) {
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Tipo de Producto: " + tipoProducto +
                ", Cantidad: " + cantidad;
    }
}
