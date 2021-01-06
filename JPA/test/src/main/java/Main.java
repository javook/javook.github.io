import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import models.Course;
import models.Student;
import models.Teacher;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager entityManager1 = null;
        EntityManager entityManager2 = null;
        EntityManager entityManager3 = null;
        try {
            factory = Persistence.createEntityManagerFactory("test");
            entityManager1 = factory.createEntityManager();
            entityManager2 = factory.createEntityManager();
            entityManager3 = factory.createEntityManager();

            Teacher teacher = new Teacher();
            Teacher teacher1 = new Teacher();
            Student st1 = new Student();
            Student st2 = new Student();
            Course cs1 = new Course();
            Course cs2 = new Course();
            st1.setName("mahdi");
            st2.setName("ali");
            entityManager1.getTransaction().begin();
            teacher.setName("amir");
            teacher1.setName("ali");
            entityManager1.persist(teacher1);
            entityManager1.persist(teacher);
            entityManager1.getTransaction().commit();
            entityManager1.close();

            entityManager2.getTransaction().begin();
            st1.setTeacher(teacher);
            st2.setTeacher(teacher);
            entityManager2.persist(st1);
            entityManager2.persist(st2);
            entityManager2.getTransaction().commit();
            entityManager2.close();

            entityManager3.getTransaction().begin();
            cs1.setName("Basic Programming");
            cs1.setStudent(st1);
            cs1.setTeacher(teacher);
            cs2.setName("Advanced Programming");
            cs2.setStudent(st1);
            cs2.setTeacher(teacher);
            entityManager3.persist(cs1);
            entityManager3.persist(cs2);
            entityManager3.getTransaction().commit();
            entityManager3.close();
        }catch(Exception e){
            e.printStackTrace();
            entityManager1.getTransaction().rollback();
        }
        finally {
            if (!entityManager1.equals(null)){entityManager1.close();}
            if (!factory.equals(null)){factory.close();}
        }
    }
}
