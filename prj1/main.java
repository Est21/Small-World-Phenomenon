package prj1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import prj1.Movie;

public class main {
	static List<Actor> actors = new ArrayList();
	
	private static void parser() {
		try {
            File file = new File("C:\\Users\\LENOVO\\Desktop\\movies.txt");   // Dosya adını burda argüman olarak alll !!!!!!!!!!!!!!!!
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                seperateElement(line);
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı!");
        }
		
	}
	private static void seperateElement(String line) {
		
		String currentMovie;
		boolean isDuplicate = false;
		String[] lines = line.split("/");
		
		currentMovie = line.split("/")[0];
				
		for(int i = 1; i < line.split("/").length;i++)
		{
			isDuplicate = false;
			
			for (int j = 0; j < actors.size(); j++) {
				if (lines[i].equals(actors.get(j).getName())) {
					isDuplicate = true;
					actors.get(j).addMovie(currentMovie);

				} 
			}
			if (!isDuplicate) {
				actors.add(Actor.getActor(lines[i]));
				actors.get(actors.size() - 1).addMovie(currentMovie);
			}
		}
		
	}
	static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
	static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j : adj.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
		
		List<List<Integer>> graph = new ArrayList<>();
		parser();
		
		for (int i = 0; i < actors.size() ; i++) {
			System.out.println(actors.get(i));
		}
	}

}
