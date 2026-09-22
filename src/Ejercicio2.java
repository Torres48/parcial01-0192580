import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ventas = new int[4][5];
        System.out.println("=== REGISTRO DE VENTAS POR SUCURSAL Y PRODUTO ===");

        for (int f = 0; f < 4; f++) {
            System.out.println("\n--- Sucursal "+ (f + 1) + " ---");
            for (int c = 0; c < 5; c++) {
                int valor;
                do {
                    System.out.print("Ingrese ventas del Producto " + (c + 1)+ ": ");
                    valor = scanner.nextInt();
                    if (valor < 0) {
                        System.out.println("Error: La cantidad no puede ser negativa. Intente de nuevo.");
                    }
                } while (valor < 0);
                 ventas[f][c] = valor;
            }
        }

        int[] totalSucursal = new int[4];
        int registrosMayores30 = 0;

        for (int f = 0; f < 4; f++) {
            int sumaFila = 0;
            for (int c = 0; c < 5; c++) {
                sumaFila += ventas[f][c];
                if (ventas[f][c] > 30) {
                    registrosMayores30++;
                }
            }
            totalSucursal[f] = sumaFila;
        }
        int[] totalProducto = new int[5];

        for (int c = 0; c < 5; c++) {
            int sumaColumna = 0;
            for (int f = 0; f < 4; f++) {
                sumaColumna += ventas[f][c];
            }
            totalProducto[c] = sumaColumna;
        }

        int minVentasSucursal = totalSucursal[0];
        int sucursalMenor = 1;

        for (int f = 1; f < 4; f++) {
            if (totalSucursal[f] < minVentasSucursal) {
                minVentasSucursal = totalSucursal[f];
                sucursalMenor = f + 1;
            }
        }

        int maxVentasProducto = totalProducto[0];
        int productoMayor = 1;

        for (int c = 1; c < 5; c++) {
            if (totalProducto[c] > maxVentasProducto) {
                maxVentasProducto = totalProducto[c];
                productoMayor = c + 1;
            }
        }

        System.out.println("\n=== TOTALES POR SUCURSAL ===");
        for (int f = 0; f < 4; f++) {
            System.out.println("Sucursal " + (f + 1) + ": " + totalSucursal[f] + " unidades");
        }

        System.out.println("\n=== TOTALES POR PRODUCTO ===");
        for (int c = 0; c < 5; c++) {
            System.out.println("Producto " + (c + 1) + ": " + totalProducto[c] + " unidades");
        }
        System.out.println("\n=== ANÁLISIS GENERAL ===");
        System.out.println("Sucursal con menor venta total: Sucursal " + sucursalMenor + " (" + minVentasSucursal + " unidades)");
        System.out.println("Producto más vendido: Producto " + productoMayor + " (" + maxVentasProducto + " unidades)");
        System.out.println("Registros con más de 30 unidades vendidas: " + registrosMayores30);
        System.out.println("\n=== MATRIZ DE VENTAS ===");
        System.out.print("           ");
        for (int c = 0; c < 5; c++) {
            System.out.print("Prod " + (c + 1) + "   ");
        }
        System.out.println();

        for (int f = 0; f < 4; f++) {
            System.out.print("Sucursal " + (f + 1) + " ");
            for (int c = 0; c < 5; c++) {
                System.out.printf("%-9d", ventas[f][c]);
            }
            System.out.println();
        }
        scanner.close();
    }
}