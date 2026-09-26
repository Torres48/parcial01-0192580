import java.util.Scanner;

public class Correccion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] ventas = new int[4][5];
        int[] totalSucursal = new int[4];
        int[] totalProducto = new int[5];
        int mayores30 = 0, sucMenor = 0, prodMayor = 0;

        System.out.println("=== REGISTRO DE VENTAS POR SUCURSAL Y PRODUCTO ===");

        for (int f = 0; f < 4; f++) {
            System.out.println("\n--- Sucursal " + (f + 1) + " ---");
            for (int c = 0; c < 5; c++) {
                int valor;
                do {
                    System.out.print("Ingrese ventas del Producto " + (c + 1) + ": ");
                    valor = sc.nextInt();
                    if (valor < 0) System.out.println("Error: La cantidad no puede ser negativa.");
                } while (valor < 0);

                // Asignación y acumulaciones inmediatas
                ventas[f][c] = valor;
                totalSucursal[f] += valor;
                totalProducto[c] += valor;
                if (valor > 30) mayores30++;
            }
            if (totalSucursal[f] < totalSucursal[sucMenor]) sucMenor = f;
        }

        // Buscar producto más vendido
        for (int c = 1; c < 5; c++) {
            if (totalProducto[c] > totalProducto[prodMayor]) prodMayor = c;
        }

        // Imprimir Totales
        System.out.println("\n=== TOTALES POR SUCURSAL ===");
        for (int f = 0; f < 4; f++) System.out.println("Sucursal " + (f + 1) + ": " + totalSucursal[f] + " unidades");

        System.out.println("\n=== TOTALES POR PRODUCTO ===");
        for (int c = 0; c < 5; c++) System.out.println("Producto " + (c + 1) + ": " + totalProducto[c] + " unidades");

        // Imprimir Análisis General
        System.out.println("\n=== ANÁLISIS GENERAL ===");
        System.out.println("Sucursal con menor venta: Sucursal " + (sucMenor + 1) + " (" + totalSucursal[sucMenor] + " unidades)");
        System.out.println("Producto más vendido: Producto " + (prodMayor + 1) + " (" + totalProducto[prodMayor] + " unidades)");
        System.out.println("Registros con más de 30 unidades vendidas: " + mayores30);

        // Imprimir Matriz
        System.out.println("\n=== MATRIZ DE VENTAS ===");
        System.out.print("           ");
        for (int c = 0; c < 5; c++) System.out.print("Prod " + (c + 1) + "   ");
        System.out.println();

        for (int f = 0; f < 4; f++) {
            System.out.printf("Sucursal %d ", f + 1);
            for (int c = 0; c < 5; c++) System.out.printf("%-9d", ventas[f][c]);
            System.out.println();
        }
        sc.close();
    }
}
