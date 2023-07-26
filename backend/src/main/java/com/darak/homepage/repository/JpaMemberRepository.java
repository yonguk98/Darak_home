package com.darak.homepage.repository;

import com.darak.homepage.domain.Users;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;
    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Users save(Users users) {
        em.persist(users);
        return users;
    }

    @Override
    public Optional<Users> findByIdentity(Long identity) {
        Users users = em.find(Users.class, identity);
        return Optional.ofNullable(users);
    }

    @Override
    public Optional<Users> findById(String id) {
        List<Users> result = em.createQuery("select m from users as m where  m.id = :id", Users.class)
                .setParameter("id",id).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Users> findByPassword(String password) {
        List<Users> result = em.createQuery("select m from users as m where  m.password = :password", Users.class)
                .setParameter("password",password).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Users> findByName(String name) {
        List<Users> result = em.createQuery("select m from users as m where  m.name = :name", Users.class)
                .setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Users> findAll() {
        return em.createQuery("select m from user as m", Users.class)
                .getResultList();
    }
}
