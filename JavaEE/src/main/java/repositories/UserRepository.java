package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import models.RoleEnum;
import models.entities.UsersEntity;

import javax.ejb.Stateless;

@Stateless
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public void instance(UsersEntity entity) {
        entity.setRole(String.valueOf(RoleEnum.USER));
        em.persist(entity);
    }

    public Iterable<UsersEntity> findAll() {
        return em.createQuery("select i from UsersEntity i", UsersEntity.class).getResultList();
    }

    public UsersEntity findObject(UsersEntity user) {
        return em.createQuery("select i from UsersEntity i " +
                                "where i.id = :id " +
                                "and i.email = :email " +
                                "and i.firstName = :firstName " +
                                "and i.lastName = :lastName" +
                                "and i.role = :role",
                        UsersEntity.class)
                .setParameter("id", user.getId())
                .setParameter("email", user.getEmail())
                .setParameter("firstName", user.getFirstName())
                .setParameter("lastName", user.getLastName())
                .setParameter("role", user.getRole())
                .getSingleResult();
    }

    public UsersEntity findById(int id) {
        return em.createQuery("select i from UsersEntity i where i.id = :id", UsersEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public UsersEntity findByFirstNameAndPassword(String firstName, int password) {
        return em.createQuery("select i from UsersEntity i where i.firstName = :firstName" +
                        "and i.password = :password", UsersEntity.class)
                .setParameter("firstName", firstName)
                .setParameter("password", password)
                .getSingleResult();
    }

    public void delete(int id) {
        UsersEntity entity = em.find(UsersEntity.class, id);
        em.remove(entity);
    }

    public UsersEntity findByFirstName(String firstName) {
        return em.createQuery("select i from UsersEntity i where i.firstName = :firstName", UsersEntity.class)
                .setParameter("firstName", firstName)
                .getSingleResult();
    }

    public int getIdByName(String firstName) {
        return findByFirstName(firstName).getId();
    }
}
