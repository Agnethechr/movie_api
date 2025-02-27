package app;

import app.Callable.ApiFetcherCallable;
import app.DTO.CastDTO;
import app.DTO.CrewMemberDTO;
import app.DTO.GenreDTO;
import app.DTO.MediaDTO;
import app.Services.MovieService;
import app.config.HibernateConfig;
import app.daos.CastMemberDAO;
import app.daos.CrewMemberDAO;
import app.daos.GenreDAO;
import app.daos.MovieDAO;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static final MovieDAO movieDAO = MovieDAO.getInstance(emf);
    private static final CastMemberDAO castMemberDAO = CastMemberDAO.getInstance(emf);
    private static final CrewMemberDAO crewMemberDAO = CrewMemberDAO.getInstance(emf);
    private static final GenreDAO genreDAO = GenreDAO.getInstance(emf);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String key = System.getenv("api_key");
        String apiUrl = "https://api.themoviedb.org/3/genre/movie/list?language=en&api_key=" + key;

        ApiFetcherCallable apiFetcherCallable = new ApiFetcherCallable(apiUrl);
        apiFetcherCallable.runAllUrl();


        MovieService apiReader = new MovieService();

        // Hent data fra API
        String response1 = apiReader.getDataFromURL(
                "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&release_date.gte=2020-01-01&release_date.lte=2025-01-01&sort_by=popularity.desc&with_original_language=da&api_key=" + key
        );

        MediaDTO movieDTO = apiReader.getAllMovies(response1);
        CrewMemberDTO movieDTO1 = apiReader.getAllMovies(response1).getCrewMember();
        CastDTO movieDTO2 = apiReader.getAllMovies(response1).getCast();
        GenreDTO movieDTO3 = apiReader.getAllMovies(response1).getGenre();
        if (movieDTO == null) {
            throw new IllegalStateException("getAllMovies(response1) returned null!");
        }
        movieDAO.create(movieDTO);
        castMemberDAO.create(movieDTO2, movieDTO);
        crewMemberDAO.create(movieDTO1, movieDTO);
        genreDAO.create(movieDTO3, movieDTO);

    }

}
