package app;

import app.DTO.MediaDTO;
import app.Services.MovieService;

public class Main {
    public static void main(String[] args) {
        MovieService apiReader = new MovieService();
        String movieId = "94605";
        String imdbId = "tt0111161";
        String serieId = "tt11126994";
        String key = (System.getenv("api_key"));
        String response1 = apiReader.getDataFromURL("https://api.themoviedb.org/3/find/"+ imdbId + "?external_source=imdb_id&api_key="+ key);
        String response2 = apiReader.getDataFromURL("https://api.themoviedb.org/3/find/"+ serieId + "?external_source=imdb_id&api_key="+ key);
        String response3 = apiReader.getDataFromURL("https://api.themoviedb.org/3/movie/" + movieId + "?append_to_response=credits&language=en-US&api_key="+ key);
        MediaDTO movieDTO1 = apiReader.getMovieById(response1);
        MediaDTO movieDTO2 = apiReader.getMovieById(response2);
        MediaDTO movieDTO3 = apiReader.getMovieById(response3);
        System.out.println("fra main "+ movieDTO3);
        System.out.println("fra main "+ movieDTO1);
        System.out.println("fra main "+ movieDTO2);

    }
}