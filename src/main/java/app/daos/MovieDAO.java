package app.daos;

import app.DTO.MediaDTO;
import app.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class MovieDAO implements IDAO<MediaDTO, Integer> {

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

    @Override
    public MediaDTO create(MediaDTO mediaDTO) {
        EntityManager em = emf.createEntityManager();
        Movie movie = em.find(Movie.class, mediaDTO.getId());

        if (movie != null) {
            return new MediaDTO(movie);
        }
        movie = new Movie(mediaDTO);

        try {
            em.getTransaction().begin();

            if (movie.getGenres() != null) {
                movie.setGenres(movie.getGenres().stream().map(genre -> {
                    Genre genres = em.find(Genre.class, genre.getId());
                    return genres != null ? genres : genre;
                }).collect(Collectors.toList()));
            }
            if (movie.getCredits() != null) {
                if (movie.getCredits().getCast() != null) {
                    movie.getCredits().setCast(movie.getCredits().getCast().stream().map(cast -> {
                        Cast casts = em.find(Cast.class, cast.getId());
                        return casts != null ? casts : em.merge(cast);
                    }).collect(Collectors.toList()));
                }
                if (movie.getCredits().getCrew() != null) {
                    movie.getCredits().setCrew(movie.getCredits().getCrew().stream().map(crewMember -> {
                        CrewMember crews = em.find(CrewMember.class, crewMember.getId());
                        return crews != null ? crews : em.merge(crewMember);
                    }).collect(Collectors.toList()));
                }
            }
            em.persist(movie);
            em.getTransaction().commit();
            return new MediaDTO(movie);

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public MediaDTO update(MediaDTO mediaDTO) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<MediaDTO> getAll() {
        return List.of();
    }

    @Override
    public MediaDTO getById(Integer integer) {
        return null;
    }

}