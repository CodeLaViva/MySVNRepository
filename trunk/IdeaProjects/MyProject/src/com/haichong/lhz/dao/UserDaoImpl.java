package com.haichong.lhz.dao;

import com.haichong.lhz.model.AccountInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Long save(AccountInfo accountInfo) {
        em.persist(accountInfo);
        return accountInfo.getAccountId();
    }
}

/*
public class UserDaoImpl implements UserDao {
    public AccountInfo save(AccountInfo accountInfo) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("SimplePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(accountInfo);
        em.getTransaction().commit();
        emf.close();
        return accountInfo;
    }
}*/
