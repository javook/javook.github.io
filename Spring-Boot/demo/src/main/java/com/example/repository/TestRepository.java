package com.example.repository;

import com.example.dao.MyDAO;
import com.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class TestRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void save(MyDAO dao){
        User newUser = new User(dao.getFirstName(), dao.getLastName());
        entityManager.persist(newUser);
//        try {
//            entityManager.createNativeQuery("INSERT INTO user (first_name, last_name) VALUES(?,?)")
//                    .setParameter(1, newUser.getFirstName())
//                    .setParameter(2, newUser.getLastName())
//                    .executeUpdate();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
   }

   public MyDAO findById(Integer id){
        TypedQuery<User> userTypedQuery = entityManager.createQuery("select u from User u where u.id =:userId",User.class);
        userTypedQuery.setParameter("userId",id);
        User findedUser = userTypedQuery.getSingleResult();
        MyDAO newDao = new MyDAO(findedUser.getFirstName(), findedUser.getLastName());
        return  newDao;
   }

}
