package app.dao;

import app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }


    @Override
    public void saveUser(String name, String lastName, String nationality) {
        User user = new User(name, lastName, nationality);
        em.persist(user);
    }


    @Override
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }


    @Override
    public void editUser(Long id, String name, String lastName, String nationality) {
        User user = em.find(User.class, id);
        if (user != null) {
            user.setNationality(nationality);
            user.setName(name);
            user.setLastName(lastName);
        }
    }

    @Override
    public List<User> showUsers() {
        return em.createQuery("FROM User", User.class).getResultList();
    }
}