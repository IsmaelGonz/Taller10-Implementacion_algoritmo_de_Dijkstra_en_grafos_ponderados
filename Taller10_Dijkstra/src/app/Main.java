package app;

import algorithm.Dijkstra;
import model.Graph;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        File dataFolder = new File("data");

        if (!dataFolder.exists() || !dataFolder.isDirectory()) {
            System.out.println("La carpeta 'data' no existe.");
            return;
        }

        boolean running = true;

        while (running) {

            File[] files = dataFolder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (files == null || files.length == 0) {
                System.out.println("No hay archivos .txt en la carpeta data.");
                return;
            }

            // ===== MENÚ DE ARCHIVOS =====
            System.out.println("\nArchivos disponibles:");
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + ". " + files[i].getName());
            }

            System.out.print("Seleccione un archivo: ");
            int option = input.nextInt();

            if (option < 1 || option > files.length) {
                System.out.println("Opción inválida. Intente nuevamente.");
                continue;
            }

            File selectedFile = files[option - 1];

            try {
                Graph graph = new Graph(selectedFile.getPath());
                int source = 0; // nodo origen fijo
                Dijkstra.run(graph, source);
            } catch (Exception e) {
                System.out.println("Error al procesar el archivo.");
                continue;
            }

            // ===== MENÚ POST-EJECUCIÓN (VALIDADO) =====
            int nextOption;

            do {
                System.out.println("\n¿Qué desea hacer ahora?");
                System.out.println("1. Seleccionar otro archivo");
                System.out.println("2. Salir");
                System.out.print("Opción: ");

                nextOption = input.nextInt();

                if (nextOption != 1 && nextOption != 2) {
                    System.out.println("Opción inválida. Ingrese 1 o 2.");
                }

            } while (nextOption != 1 && nextOption != 2);

            if (nextOption == 2) {
                running = false;
            }
        }

        System.out.println("\nPrograma finalizado.");
        input.close();
    }
}
