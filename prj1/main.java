package prj1;

import java.io.*;
import java.util.*;

public class main {

    static List<Actor> actors = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static Map<String, Integer> actorIndex = new HashMap<>();

    private static void parser() {
        try {
            File file = new File("D:\\movies.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                seperateElementAndBuildGraph(line);  // <-- değişti
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı!");
        }
    }

    private static int getOrCreateActorId(String name, String currentMovie) {
        Integer id = actorIndex.get(name);
        if (id != null) {
            actors.get(id).addMovie(currentMovie);
            return id;
        }

        // yeni aktör
        actors.add(Actor.getActor(name));
        int newId = actors.size() - 1;
        actorIndex.put(name, newId);

        actors.get(newId).addMovie(currentMovie);

        // graph node'u da ekle
        graph.add(new ArrayList<>());
        return newId;
    }

    private static void addUndirectedEdge(int u, int v) {
        if (u == v) return;
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    private static void seperateElementAndBuildGraph(String line) {
        String[] parts = line.split("/");
        String currentMovie = parts[0];

        List<Integer> ids = new ArrayList<>();

        for (int i = 1; i < parts.length; i++) {
            String actorName = parts[i].trim();
            int id = getOrCreateActorId(actorName, currentMovie);
            ids.add(id);
        }

        // aynı filmdeki herkes birbirine bağlı
        for (int a = 0; a < ids.size(); a++) {
            for (int b = a + 1; b < ids.size(); b++) {
                addUndirectedEdge(ids.get(a), ids.get(b));
            }
        }
    }

    static void displayAdjList() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " (" + actors.get(i).getName() + "): ");
            for (int j : graph.get(i)) System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        parser();

        for (int i = 0; i < actors.size(); i++) {
            System.out.println(i + " -> " + actors.get(i));
        }

        displayAdjList();
    }
}
