package prj1;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private String movieName;
	private List<Actor> actors = new ArrayList();
	
	public Movie(String movieName) {
		this.movieName = movieName;
	}
	
	public static Movie getMovie(String movieName) {
		return new Movie(movieName);
	}
	
	public void addActor(Actor actor) {
		this.actors.add(actor);
	}
	
	@Override
    public String toString() {
        return "Movie : " + movieName;
    }

}
