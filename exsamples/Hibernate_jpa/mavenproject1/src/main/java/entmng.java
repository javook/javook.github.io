
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alishz
 */
public class entmng {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test"); //ijad object emf
        EntityManager entitymanager = factory.createEntityManager(); // ijad object em

        entitymanager.getTransaction().begin(); // start kardan entitymanager baraye anjame amaliat(tarakonesh)

        teacher teacher1 = new teacher();
//        teacher1.setTeacherid(1); // chon generatedvalue Auto ast pass lazem be set kardan id nist
        teacher1.setTname("reza rezai");

        teacher teacher2 = new teacher();
        teacher2.setTname("ali bayan");

        course course1 = new course();
        course1.setCid(1);
        course1.setNamecourse("riazi");
        course1.setCteacher(teacher1);
        entitymanager.persist(course1); // pas az persist kardane course1 , teacher marbute yani teacher1 ham besurate auto persist mishavad, 
        //chon rabete one-to-one darand va az cascade.All dar object course sakhte shode dar course estefade shode
        course course2 = new course();
        course2.setCid(2);
        course2.setNamecourse("fizik");
        course2.setCteacher(teacher2);
        entitymanager.persist(course2);

        student student1 = new student();
        student1.setSname("ali alavi");
        student1.setSteacher(teacher1);
        student1.getCstudent().add(course1);
        entitymanager.persist(student1);

        student student2 = new student();
        student2.setSname("ali alavi");
        student2.setSteacher(teacher2);
        student2.getCstudent().add(course2);
        entitymanager.persist(student2);
        entitymanager.getTransaction().commit(); //sabt taghirat(tarakonesh) dar database va close kardan database

        System.out.println("Successfully");

        factory.close(); //close kardan objecthaye factory va entitymanager dar enteha
        entitymanager.close();

    }

//        teacher1.getTstudent();
//        teacher2.getTstudent();
//        teacher1.getTidcourse();
//        teacher2.getTidcourse();
//
//        teacher t1 = new teacher();
//        t1.setTeacherid(1);
//        t1.setTname("rezai");
//        entitymanager.persist(t1);
//        entitymanager.getTransaction().commit();
//        EntityManagerFactory factory = null;
//        EntityManager entityMgr = null;
//
//        try {
//            factory = Persistence.createEntityManagerFactory("test");
//            entityMgr = factory.createEntityManager();
//            entityMgr.getTransaction().begin();
//            course course1 = new course(1, "riazi");
//            course course2 = new course(2, "zist");
//
//            student std1 = new student(1, "mehran rezai");
//            student std2 = new student(2, "ali alavi");
//
//            teacher teacher1 = new teacher(22, "ghasem mohamadi");
//            teacher teacher2 = new teacher(33, "reza rezai");
//           std.setName("Harry Potter");
//            std.setCourse("chemistry");
//            entityMgr.persist(std);
    //entityMgr.getTransaction().commit();
//        } catch (Exception e) {
//            
//            if (entityMgr != null) {
//                entityMgr.getTransaction().rollback();
//            }
//        } finally {
}
