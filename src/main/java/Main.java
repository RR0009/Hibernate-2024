import models.Gender;
import models.Passport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

                session.save( new User("Nate", "dwindle@gmail.com", Arrays.asList("java","js"), Gender.MALE, new Passport("abby334")));
                session.save( new User("Kate", "diminish@gmail.com", Arrays.asList("php","Nod.js"), Gender.FEMALE, new Passport("nanny334")));
                session.save( new User("Anna", "shorten@gmail.com", Arrays.asList("C#","Angular"), Gender.FEMALE, new Passport("catty334")));

        session.getTransaction().commit();


       session.createQuery("select u from User u").list().forEach(System.out::println);


        session.close();
        sessionFactory.close();


    }
}