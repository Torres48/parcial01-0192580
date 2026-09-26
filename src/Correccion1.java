import java.util.Scanner;

//Correccion de optimizacion ejercicio 1

public class Correccion1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] paquetes = new int[10];
        int total = 0, menor = Integer.MAX_VALUE, horaMenor = 0;

        System.out.println("=== REGISTRO DE PAQUETES PROCESADOS POR HORA ===");

        for (int i = 0; i < 10; i++) {
            do {
                System.out.print("Ingrese paquetes procesados en la hora " + (i + 1) + ": ");
                paquetes[i] = scanner.nextInt();
                if (paquetes[i] < 0) {
                    System.out.println("Error:No puede ser negativa.");
                }
            } while (paquetes[i] < 0);

            total += paquetes[i];
            if (paquetes[i] < menor) {
                menor = paquetes[i];
                horaMenor = i + 1;
            }
        }
        double promedio = total / 10.0;
        int bajoPromedio = 0, rachaActual = 0, rachaMax = 0;

        System.out.println("\n=== LISTADO FINAL POR HORA ===");
        for (int i = 0; i < 10; i++) {
            System.out.println("Hora " + (i + 1) + ": " + paquetes[i] + " paquetes");
            
            if (paquetes[i] < promedio) {
                bajoPromedio++;
                rachaMax = Math.max(rachaMax, ++rachaActual);
            } else {
                rachaActual = 0;
            }
        }

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Total de paquetes: " + total);
        System.out.println("Promedio por hora: " + promedio);
        System.out.println("Hora con menor producción: Hora " + horaMenor + " (" + menor + " paquetes)");
        System.out.println("Horas bajo el promedio: " + bajoPromedio);
        System.out.println("Racha más larga bajo el promedio: " + rachaMax + " hora(s)");

        scanner.close();
    }
}