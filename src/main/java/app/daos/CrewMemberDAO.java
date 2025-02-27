package app.daos;

import app.DTO.CastDTO;
import app.DTO.CrewMemberDTO;
import app.DTO.MediaDTO;
import app.entity.Cast;
import app.entity.CrewMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CrewMemberDAO {

    private static EntityManagerFactory emf;
    private static CrewMemberDAO instance;

    private CrewMemberDAO() {
    }

    ;

    public static CrewMemberDAO getInstance(EntityManagerFactory _emf) {
        if (emf == null) {
            emf = _emf;
            instance = new CrewMemberDAO();
        }
        return instance;
    }

    public CrewMemberDTO create(CrewMemberDTO crew, MediaDTO mediaDTO) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            CrewMemberDTO crewDTO = mediaDTO.getCrewMember();
            CrewMember newCrewMember = CrewMember.builder()
                    .id(crewDTO.getId())
                    .crewId(crewDTO.getCrewId())
                    .name(crewDTO.getName())
                    .job(crewDTO.getJob())
                    .department(crewDTO.getDepartment())
                    .knownForDepartment(crewDTO.getKnownForDepartment())
                    .build();
            em.merge(newCrewMember);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return crew;
    }
}
