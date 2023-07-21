package com.darak.homepage.repository;

import com.darak.homepage.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;
    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findByIdentity(Long identity) {
        User user = em.find(User.class, identity);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findById(String id) {
        List<User> result = em.createQuery("select m from User as m where  m.id = :id", User.class)
                .setParameter("id",id).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByPassword(String password) {
        List<User> result = em.createQuery("select m from User as m where  m.password = :password", User.class)
                .setParameter("password",password).getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result = em.createQuery("select m from User as m where  m.name = :name", User.class)
                .setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select m from User as m", User.class)
                .getResultList();
    }
}
