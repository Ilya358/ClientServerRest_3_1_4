package com.example.ClientServer.web.dao;

import com.example.ClientServer.web.model.Role;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ToString
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("from Role where name =:name").setParameter("name", name).getSingleResult();
    }
    public List<Role> getRoleList() {
        return entityManager.createQuery("from Role").getResultList();
    }
}
