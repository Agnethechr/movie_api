package app.daos;

import app.DTO.GenreDTO;
import app.DTO.MediaDTO;
import app.entity.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class GenreDAO {

    private static EntityManagerFactory emf;
    private static GenreDAO instance;

    private GenreDAO() {}

    public static GenreDAO getInstance(EntityManagerFactory _emf) {
        if(emf == null) {
            emf = _emf;
            instance = new GenreDAO();
        }
        return instance;
    }

    public GenreDTO create(GenreDTO genre, MediaDTO mediaDTO) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            GenreDTO genreDTO = mediaDTO.getGenre();
            Genre genreEntity = Genre.builder()
                    .id(genreDTO.getId())
                    .name(genreDTO.getName())
                    .build();
            em.merge(genreEntity);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return genre;
    }

}
