package edu.kpi.boot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Abrasha on 31-Mar-16.
 */
public class Starter {

    public static void main(String[] args) throws InterruptedException {

        SessionFactory factory = new Configuration()
                .configure("/hibernate/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        session.close();
        factory.close();


        Thread.sleep(1000000);

    }

}
