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

        // ===== BUCLE PRINCIPAL DEL PROGRAMA =====
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
            int fileOption = input.nextInt();

            if (fileOption < 1 || fileOption > files.length) {
                System.out.println("Opción inválida.");
                continue;
            }

            File selectedFile = files[fileOption - 1];
            Graph graph;

            try {
                graph = new Graph(selectedFile.getPath());
            } catch (Exception e) {
                System.out.println("Error al leer el archivo.");
                continue;
            }

            boolean sameGraph = true;

            // ===== BUCLE PARA CAMBIAR NODO DE ORIGEN =====
            while (sameGraph) {

                int n = graph.getN();
                int source;

                // Ingreso y validación del nodo origen
                do {
                    System.out.print("Ingrese el nodo de origen (0 a " + (n - 1) + "): ");
                    source = input.nextInt();

                    if (source < 0 || source >= n) {
                        System.out.println("Nodo inválido. Intente nuevamente.");
                    }
                } while (source < 0 || source >= n);

                // Ejecución de Dijkstra
                Dijkstra.run(graph, source);

                // ===== MENÚ POST-TABLA =====
                int nextOption;

                do {
                    System.out.println("\n¿Qué desea hacer ahora?");
                    System.out.println("1. Volver a seleccionar otro nodo de origen");
                    System.out.println("2. Seleccionar otro archivo");
                    System.out.println("3. Salir");
                    System.out.print("Opción: ");

                    nextOption = input.nextInt();

                    if (nextOption < 1 || nextOption > 3) {
                        System.out.println("Opción inválida. Ingrese 1, 2 o 3.");
                    }

                } while (nextOption < 1 || nextOption > 3);

                if (nextOption == 2) {
                    sameGraph = false; // vuelve al menú de archivos
                } else if (nextOption == 3) {
                    sameGraph = false;
                    running = false; // termina el programa
                }
                // Si elige 1, simplemente repite el bucle y pide otro origen
            }
        }

        System.out.println("\nPrograma finalizado.");
        input.close();
    }
}
