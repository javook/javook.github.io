package com.example.repository;

import com.example.dao.MyDAO;
import com.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRepository {

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

   public List<MyDAO> findAll(){
       TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
       List<User> userList= query.getResultList();
       List<MyDAO> daoList = new ArrayList<>();
       for (User user: userList) {
            daoList.add(UsertoDAO(user));
       }
       return daoList;
   }

   @Transactional
   public void update(Integer id, String firstName, String lastName){
        User user = new User();
        user = entityManager.find(User.class, id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        System.out.println("\n\n\n"+firstName+"\n\n"+lastName+"\n\n");
        System.out.println("\n\n\n"+user.getFirstName()+"\n\n"+user.getLastName()+"\n\n");
        entityManager.persist(user);
   }

   @Transactional
   public void delete(Integer id){
        User user = new User();
        user = entityManager.find(User.class, id);
        entityManager.remove(user);
   }

    public MyDAO UsertoDAO(User user){
        return new MyDAO(user.getFirstName(),user.getLastName());
    }
}
