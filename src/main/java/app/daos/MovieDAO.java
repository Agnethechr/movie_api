package app.daos;

import app.DTO.MediaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class MovieDAO {

    private static EntityManagerFactory emf;
    private static MovieDAO instance;
    private EntityManager entityManager;

    private MovieDAO(){}

    public static MovieDAO getInstance(EntityManagerFactory _emf){
        if(emf == null){
            emf = _emf;
            instance = new MovieDAO();
        }
        return instance;
    }

    private MovieDAO saveMovies(MediaDTO mediaDTO){
        entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

           } catch (Exception e){
            e.printStackTrace();
        } finally {
            transaction.commit();
            entityManager.close();
        }      return null;
    }
}
