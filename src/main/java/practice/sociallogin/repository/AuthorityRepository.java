package practice.sociallogin.repository;

import org.springframework.stereotype.Repository;
import practice.sociallogin.model.Authority;
import practice.sociallogin.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorityRepository {

    @PersistenceContext
    EntityManager em;

    public Authority findById(String id) {
        Authority authority = em.find(Authority.class, id);
        return authority;
    }

    public void save(Authority authority) {
        Authority findAuthority = findById(authority.getId());
        if (findAuthority != null) {
            return;
        }
        em.persist(authority);
    }
}
