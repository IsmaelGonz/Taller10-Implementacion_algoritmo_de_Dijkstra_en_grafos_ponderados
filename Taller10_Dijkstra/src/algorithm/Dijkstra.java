package algorithm;

import model.Edge;
import model.Graph;

import java.util.Arrays;

public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    public static void run(Graph graph, int source) {

        int n = graph.getN();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = minDistance(dist, visited);
            if (u == -1) break;

            visited[u] = true;

            for (Edge e : graph.getAdj().get(u)) {
                int v = e.to;
                int w = e.weight;

                if (!visited[v] && dist[u] != INF &&
                        dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                }
            }
        }

        printAdaptiveTable(dist, prev);
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, idx = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    // ===== TABLA ADAPTABLE =====
    private static void printAdaptiveTable(int[] dist, int[] prev) {

        int n = dist.length;

        String[] caminos = new String[n];
        String[] distancias = new String[n];

        int maxNodo = "Nodo".length();
        int maxDist = "Distancia".length();
        int maxCamino = "Camino".length();

        for (int i = 0; i < n; i++) {
            caminos[i] = buildPath(prev, i).trim();
            distancias[i] = (dist[i] == INF) ? "INF" : String.valueOf(dist[i]);

            maxNodo = Math.max(maxNodo, String.valueOf(i).length());
            maxDist = Math.max(maxDist, distancias[i].length());
            maxCamino = Math.max(maxCamino, caminos[i].length());
        }

        String top = "╔" + repeat("═", maxNodo + 2) +
                "╦" + repeat("═", maxDist + 2) +
                "╦" + repeat("═", maxCamino + 2) + "╗";

        String mid = "╠" + repeat("═", maxNodo + 2) +
                "╬" + repeat("═", maxDist + 2) +
                "╬" + repeat("═", maxCamino + 2) + "╣";

        String bot = "╚" + repeat("═", maxNodo + 2) +
                "╩" + repeat("═", maxDist + 2) +
                "╩" + repeat("═", maxCamino + 2) + "╝";

        System.out.println(top);
        System.out.printf("║ %-" + maxNodo + "s ║ %-" + maxDist + "s ║ %-" + maxCamino + "s ║%n",
                "Nodo", "Distancia", "Camino");
        System.out.println(mid);

        for (int i = 0; i < n; i++) {
            System.out.printf("║ %-" + maxNodo + "d ║ %-" + maxDist + "s ║ %-" + maxCamino + "s ║%n",
                    i, distancias[i], caminos[i]);
        }

        System.out.println(bot);
    }

    private static String buildPath(int[] prev, int j) {
        if (j == -1) return "";
        return buildPath(prev, prev[j]) + j + " ";
    }

    private static String repeat(String s, int times) {
        return s.repeat(Math.max(0, times));
    }
}
