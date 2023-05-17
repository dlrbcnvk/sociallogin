package practice.sociallogin.repository;

import org.springframework.stereotype.Repository;
import practice.sociallogin.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User findById(String id) {
        User user = em.find(User.class, id);
        return user;
    }

    public void register(User user) {
        User findUser = findById(user.getId());
        if (findUser != null) {
            return;
        }
        em.persist(user);
    }
}
