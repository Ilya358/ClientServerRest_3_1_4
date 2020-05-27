package com.example.ClientServer.web.dao;

import com.example.ClientServer.web.model.User;
import com.example.ClientServer.web.service.RoleService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ToString
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleService roleService;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserByName(String name) {
        return (User) entityManager.createQuery("from User where name =:name").setParameter("name", name).getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        return (User) entityManager.createQuery("from User where email =:email").setParameter("email", email).getSingleResult();
    }
}
