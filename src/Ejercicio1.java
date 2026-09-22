import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] paquetes = new int[10];
        int totalPaquetes = 0;

        System.out.println("=== REGISTRO DE PAQUETES PROCESADOS POR HORA ===");

        for (int i = 0; i < 10; i++) {
            int valor;
            do {
                System.out.print("Ingrese paquetes procesados en la hora " + (i + 1) + ": ");
                valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("Error: La cantidad no puede ser negativa. Intente de nuevo.");
                }
            } while (valor < 0);

            paquetes[i] = valor;
            totalPaquetes += valor;
        }

        double promedio = (double) totalPaquetes / 10;

        int menorCantidad = paquetes[0];
        int horaMenor = 1;

        for (int i = 1; i < 10; i++) {
            if (paquetes[i] < menorCantidad) {
                menorCantidad = paquetes[i];
                horaMenor = i + 1;
            }
        }

        int horasBajoPromedio = 0;
        int rachaActual = 0;
        int rachaMax = 0;

        for (int i = 0; i < 10; i++) {
            if (paquetes[i] < promedio) {
                horasBajoPromedio++;
                rachaActual++;
                if (rachaActual > rachaMax) {
                    rachaMax = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }

        System.out.println("\n===RESULTADOS===");
        System.out.println("Total de paquetes procesados: " + totalPaquetes);
        System.out.println("Promedio de paquetes por hora: " + promedio);
        System.out.println("Hora con menor producción: Hora " + horaMenor + " (con " + menorCantidad + " paquetes)");
        System.out.println("Horas con producción inferior al promedio: " + horasBajoPromedio);
        System.out.println("Racha más larga de horas bajo el promedio: " + rachaMax + " hora(s) consecutiva(s)");

        // 6. Listado final
        System.out.println("\n=== LISTADO FINAL POR HORA ===");
        for (int i = 0; i < 10; i++) {
            System.out.println("Hora " + (i + 1) + ": " + paquetes[i] + " paquetes");
        }

        scanner.close();
    }
}