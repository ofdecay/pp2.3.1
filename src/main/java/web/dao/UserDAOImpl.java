package web.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        User userForUpdate = entityManager.find(User.class, id);
        userForUpdate.setName(updatedUser.getName());
        return entityManager.merge(userForUpdate);
    }

    @Override
    public List<User> listOfUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
