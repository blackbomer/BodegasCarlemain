package org.example;

class Exportacion extends GestorBodegasCarlemain.Venta {
    private String destino;    // Destino de exportación
    private String cliente;    // Cliente
    private String typeBottle; // Tipo de embotellado exportacion

    private String typeBox; // tipo de cajas

    public Exportacion(String typeBottle, String typeBox, String destino, String cliente, String tipoProducto, int cantidad, String numFactura) {
        super(tipoProducto, cantidad, numFactura);
        this.destino = destino;
        this.cliente = cliente;
        this.typeBottle = typeBottle;
        this.typeBox = typeBox;
    }

    @Override
    public String getDetalleVenta() {
        return "Exportación" +
                ", Destino: " + destino +
                ", Cliente: " + cliente +
                ", Tipo de Producto: " + getTipoProducto() +
                ", Tipo de cajas: " + typeBox +
                ", Tipo de embotellado: " + typeBottle;
    }
}
