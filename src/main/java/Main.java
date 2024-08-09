import models.Gender;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        User user1 = new User("Nate","nate@gmail",Arrays.asList("java","js"), Gender.MALE);
        User user2 = new User("Kate","kate@gmail",Arrays.asList("python","js"), Gender.MALE);
        User user3 = new User("Sane","sate@gmail",Arrays.asList("Angular","js"), Gender.MALE);
        User user4 = new User("Nasty","NNate@gmail",Arrays.asList("java","js"), Gender.MALE);
        User user5 = new User("Poly","Pate@gmail",Arrays.asList("java","js"), Gender.MALE);

        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);


        session.getTransaction().commit();

//        List<User> users = session.createNativeQuery("select * from User", User.class).getResultList();

        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        System.out.println(users);

        List<Integer> idList = session.createQuery("select u.id from User u", Integer.class).getResultList();

        System.out.println(idList);

        session.close();
        sessionFactory.close();


    }
}