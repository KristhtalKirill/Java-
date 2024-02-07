package repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.entities.QuestionsEntity;

import java.util.List;

@Stateless
public class QuestionRepository {
    @PersistenceContext
    private EntityManager em;

    public void instance(QuestionsEntity entity) {
        em.persist(entity);
    }

    public List<QuestionsEntity> findAll() {
        return em.createQuery("select i from QuestionsEntity i", QuestionsEntity.class).getResultList();
    }

    public long getCount() {
        return findAll().size();
    }

    public QuestionsEntity findObject(QuestionsEntity question) {
        return em.createQuery("select i from QuestionsEntity i " +
                                "where i.id = :id " +
                                "and i.text = :text ",
                        QuestionsEntity.class)
                .setParameter("id", question.getId())
                .setParameter("text", question.getTxt())
                .getSingleResult();
    }

    public QuestionsEntity findById(int id) {
        return em.createQuery("select i from QuestionsEntity i where i.id = :id", QuestionsEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void delete(int id) {
        QuestionsEntity entity = em.find(QuestionsEntity.class, id);
        em.remove(entity);
    }
}
