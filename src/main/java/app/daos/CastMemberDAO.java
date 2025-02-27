package app.daos;

import app.DTO.CastDTO;
import app.DTO.MediaDTO;
import app.entity.Cast;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CastMemberDAO{

    private static EntityManagerFactory emf;
    private static CastMemberDAO instance;

    private CastMemberDAO(){};

    public static CastMemberDAO getInstance(EntityManagerFactory _emf){
        if(emf == null){
            emf = _emf;
            instance = new CastMemberDAO();
        }
        return instance;
    }

    public CastDTO create(CastDTO castMember, MediaDTO mediaDTO) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CastDTO castDTO = mediaDTO.getCast();
            Cast cast = Cast.builder()
                    .name(castDTO.getName())
                    .id(castDTO.getId())
                    .knownForDepartment(castDTO.getKnownForDepartment())
                    .character(castDTO.getCharacter())
                    .build();
            em.merge(cast);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return castMember;
    }
}