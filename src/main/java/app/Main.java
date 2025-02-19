package app;

import app.API.MovieFromURL;

public class Main {
    public static void main(String[] args) {
        MovieFromURL apiReader = new MovieFromURL();
        String key = (System.getenv("api_key"));
        String response = apiReader.getDataFromURL("https://api.themoviedb.org/3/find/tt9214832?external_source=imdb_id&api_key="+ key);
        String response2 = apiReader.getDataFromURL("https://api.themoviedb.org/3/find/tt11813216?external_source=imdb_id&api_key="+ key);
        System.out.println(response);
        System.out.println(response2);
    }
}