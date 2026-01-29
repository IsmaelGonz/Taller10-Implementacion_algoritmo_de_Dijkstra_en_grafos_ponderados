package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    private int n;
    private List<List<Edge>> adj;

    public Graph(String filePath) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(filePath));

        n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new Edge(v, w));
        }

        sc.close();
    }

    public int getN() {
        return n;
    }

    public List<List<Edge>> getAdj() {
        return adj;
    }
}
