package prj1;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	private String actorName;
	private List<String> movies = new ArrayList();
	
	public Actor(String actorName) {
		this.actorName = actorName;
	}
	
	public static Actor getActor(String actorName) {
		return new Actor(actorName);
	}
	
	public String getName()
	{
		return actorName;
	}
	
	public void addMovie(String movie) {
		this.movies.add(movie);
	}
	
	@Override
    public String toString() {
        return "Actor : " + actorName ;
    }
}
