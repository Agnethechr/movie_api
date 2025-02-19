package app;

import app.API.MovieFromURL;
import app.DTO.MovieDTO;
import app.entity.TvShow;

public class Main {
    public static void main(String[] args) {
        MovieFromURL apiReader = new MovieFromURL();
        MovieDTO reader = new MovieDTO();
        String movieId = "tt0903747";
        String key = (System.getenv("api_key"));
        String response = apiReader.getDataFromURL("https://api.themoviedb.org/3/find/"+ movieId + "?external_source=imdb_id&api_key="+ key);
        System.out.println(response);
        String response1 = apiReader.getDataFromURL("https://api.themoviedb.org/3/find/"+ movieId + "?external_source=imdb_id&api_key="+ key);
        MovieDTO movieDTO1 = reader.getMovieById(response1);
        System.out.println(movieDTO1);

    }
}