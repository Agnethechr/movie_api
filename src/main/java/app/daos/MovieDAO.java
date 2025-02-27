package app.daos;

import app.DTO.GenreDTO;
import app.DTO.MediaDTO;
import app.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class MovieDAO {

    private static EntityManagerFactory emf;
    private static MovieDAO instance;
    private EntityManager entityManager;

    private MovieDAO() {
    }

    public static MovieDAO getInstance(EntityManagerFactory _emf) {
        if (emf == null) {
            emf = _emf;
            instance = new MovieDAO();
        }
        return instance;
    }


    public MediaDTO create(MediaDTO mediaDTO) {
        // Save the mediaDTO to the database
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
             MediaDTO mediaDTO1 = mediaDTO;
             Movie movie = Movie.builder()
                     .id(mediaDTO1.getId())
                    .title(mediaDTO1.getTitle())
                    .imdbId(mediaDTO1.getImdbId())
                    .originalName(mediaDTO1.getOriginalTitle())
                     .originalLanguage(mediaDTO1.getOriginalLanguages())
                    .releaseDate(mediaDTO1.getReleaseDate())
                    .overview(mediaDTO1.getOverview())
                    .build();

             em.merge(movie);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return mediaDTO;
    }
}