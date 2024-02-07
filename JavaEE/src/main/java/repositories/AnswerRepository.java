package repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.entities.AnswersEntity;

import java.util.List;

@Stateless
public class AnswerRepository {
    @PersistenceContext
    private EntityManager em;

    public void instance(AnswersEntity entity) {
        em.persist(entity);
    }

    public List<AnswersEntity> findAll() {
        return em.createQuery("select i from AnswersEntity i", AnswersEntity.class).getResultList();
    }

    public long getCount() {
        return findAll().size();
    }

    public Iterable<AnswersEntity> findAnswers(AnswersEntity answer) {
        return em.createQuery("select i from AnswersEntity i " +
                                "where i.id = :id " +
                                "and i.id_question = :id_question ",
                        AnswersEntity.class)
                .setParameter("id", answer.getId())
                .setParameter("id_question", answer.getId_question())
                .getResultList();
    }

    public AnswersEntity findById(int id) {
        return em.createQuery("select i from AnswersEntity i where i.id = :id", AnswersEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void delete(int id) {
        AnswersEntity entity = em.find(AnswersEntity.class, id);
        em.remove(entity);
    }
}
