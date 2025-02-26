package app;

import app.DTO.MediaDTO;
import app.Services.MovieService;
import app.config.HibernateConfig;
import app.daos.MovieDAO;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static final MovieDAO movieDAO = MovieDAO.getInstance(emf);

    public static void main(String[] args) {
        MovieService apiReader = new MovieService();
        String key = (System.getenv("api_key"));
        String response1 = apiReader.getDataFromURL("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&release_date.gte=2020-01-01&release_date.lte=2025-01-01&sort_by=popularity.desc&with_original_language=da&api_key=" + key);
        MediaDTO movieDTO1 = apiReader.getAllMovies(response1);
        System.out.println("Fra Main "+ movieDTO1 + " Alle danske film fra 2020-2025");

        movieDAO.create(movieDTO1);
    }
}