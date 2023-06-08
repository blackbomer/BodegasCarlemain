package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GestorBodegasCarlemain {
    private List<Venta> ventas;               // Lista para almacenar las ventas realizadas
    private List<RegistroStock> registrosStock;   // Lista para almacenar los registros de stock
    private Bota[] botas; //Almacena el estado de las 50 botas de la premisa.
    //Estructura que genere numero de Factura: FAC-1, FAC-2, .... FAC-99999999
    //Estructura estatica con los 6 tipos de vino? No necesitan ser entidades.

    public GestorBodegasCarlemain() {
        ventas = new ArrayList<>();              // Inicializar la lista de ventas vacía
        registrosStock = new ArrayList<RegistroStock>();      // Inicializar la lista de registros de stock vacía
        botas= new Bota[50];
        for (int i =0;i<50; i++){
            botas[i]=(new Bota(i,null,0,null));
        }
        System.out.println(Arrays.toString(botas));
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();   // Mostrar el menú de opciones
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarVenta(scanner);   // Opción para registrar una nueva venta
                    break;
                case 2:
                    mostrarVentas();    // Opción para mostrar las ventas realizadas
                    break;
                case 3:
                    mostrarStock();     // Opción para mostrar el stock actual
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");    // Opción para salir de la aplicación
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");    // Mensaje de opción inválida
                    break;
            }
        } while (opcion != 4);   // Salir del bucle cuando se elija la opción 4 (Salir)
    }

    private void mostrarMenu() {
        System.out.println("----- Gestor Bodegas Carlemain -----");
        System.out.println("1. Registrar venta");        // Opción para registrar una nueva venta
        System.out.println("2. Mostrar ventas");         // Opción para mostrar las ventas realizadas
        System.out.println("3. Mostrar stock");          // Opción para mostrar el stock actual
        System.out.println("4. Salir");                  // Opción para salir de la aplicación
        System.out.print("Seleccione una opción: ");
    }

    private void registrarVenta(Scanner scanner) {
        System.out.print("Ingrese el tipo de venta (1: Exportación, 2: Venta directa): ");
        int tipoVenta = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (tipoVenta == 1) {
            registrarExportacion(scanner);  // Registrar una venta de exportación
        } else if (tipoVenta == 2) {
            registrarVentaDirecta(scanner); // Registrar una venta directa
        } else {
            System.out.println("Tipo de venta inválido.");  // Mensaje de tipo de venta inválido
        }
        System.out.flush(); //Limpia lo anterior.
    }

    private void registrarExportacion(Scanner scanner) {
        System.out.print("Ingrese el destino de exportación: ");
        String destino = scanner.nextLine();
        System.out.print("Ingrese el cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Ingrese el tipo de producto: ");
        String tipoProducto = scanner.nextLine();
        System.out.print("Ingrese tipo de caja: ");
        String typeBox = scanner.nextLine();
        System.out.print("Ingrese el tipo de embotellado: (● Botella grande (0,75 l) / ● Botella pequeña (0,3 l))");
        String typeBottle = scanner.nextLine();
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el número de factura emitida: ");
        String numFactura = scanner.nextLine();

        Venta venta = new Exportacion(typeBottle,typeBox, destino, cliente, tipoProducto, cantidad, numFactura);
        ventas.add(venta);

        System.out.println("Venta registrada exitosamente.");   // Mensaje de venta registrada exitosamente
    }

    private void registrarVentaDirecta(Scanner scanner) {
        System.out.print("Ingrese la fecha y hora de venta: ");
        String fechaHoraVenta = scanner.nextLine();
        System.out.print("Ingrese el tipo de producto: ");
        String tipoProducto = scanner.nextLine();
        System.out.print("Ingrese la cantidad vendida: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese tipo de caja: ");
        String typeBox = scanner.nextLine();
        System.out.print("Ingrese el tipo de embotellado: (● Botella grande (1,5 l) / ● Barril (3 l)) ");
        String typeBottle = scanner.nextLine();
        System.out.print("Ingrese el número de factura (ticket): ");
        String numFactura = scanner.nextLine();

        Venta venta = new VentaDirecta(typeBottle,typeBox, fechaHoraVenta, tipoProducto, cantidad, numFactura);
        ventas.add(venta);

        System.out.println("Venta registrada exitosamente.");   // Mensaje de venta registrada exitosamente
    }

    private void mostrarVentas() {
        System.out.println("----- Ventas Realizadas -----");
        if (ventas.isEmpty()) {
            System.out.println("No se han registrado ventas.");   // Mensaje de no se han registrado ventas
        } else {
            for (Venta venta : ventas) {
                System.out.println(venta);   // Mostrar cada venta realizada
            }
        }
    }

    private void mostrarStock() {
        System.out.println("----- Stock Actual -----");
        if (registrosStock.isEmpty()) {
            System.out.println("No hay registros de stock.");   // Mensaje de no hay registros de stock
        } else {
            for (RegistroStock stock : registrosStock) {
                System.out.println(stock);   // Mostrar cada registro de stock
            }
        }
    }

    public static void main(String[] args) {
        GestorBodegasCarlemain gestor = new GestorBodegasCarlemain();  // Crear una instancia del gestor de bodegas
        gestor.ejecutar();   // Ejecutar la aplicación del gestor de bodegas
    }

    abstract static class Venta {
        private String tipoProducto;   // Tipo de producto de la venta
        private int cantidad;          // Cantidad vendida
        private String numFactura;     // Número de factura

        public Venta(String tipoProducto, int cantidad, String numFactura) {
            this.tipoProducto = tipoProducto;
            this.cantidad = cantidad;
            this.numFactura = numFactura;
        }

        public String getTipoProducto() {
            return tipoProducto;
        }

        public abstract String getDetalleVenta();   // Método abstracto para obtener el detalle de la venta

        @Override
        public String toString() {
            return "Tipo: " + getDetalleVenta() +

                    ", Cantidad: " + cantidad +
                    ", Número de Factura: " + numFactura;
        }
    }

    static class VentaDirecta extends Venta {
        private String fechaHoraVenta;   // Fecha y hora de la venta
        private String typeBottle; //Tipo de embotellado

        private String typeBox; //Tipo de cajas

        public VentaDirecta(String typeBottle, String typeBox, String fechaHoraVenta, String tipoProducto, int cantidad, String numFactura) {
            super(tipoProducto, cantidad, numFactura);
            this.fechaHoraVenta = fechaHoraVenta;
            this.typeBottle = typeBottle;
            this.typeBox = typeBox;
        }

        @Override
        public String getDetalleVenta() {
            return "Venta Directa" +
                    ", Fecha y Hora de Venta: " + fechaHoraVenta +
                    ", Tipo de Producto: " + getTipoProducto() +
                    ", Tipo de cajas: " + typeBox +
                    ", Tipo de embotellado: " + typeBottle;
        }
    }
}
