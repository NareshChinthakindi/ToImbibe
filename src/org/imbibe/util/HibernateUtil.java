package org.imbibe.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
    /*
     A org.hibernate.SessionFactory is used to obtain org.hibernate.Session instances.
     A org.hibernate.Session represents a single-threaded unit of work.
     The org.hibernate.SessionFactory is a thread-safe global object that is instantiated once.
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
         return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
     
    public static Session getSession(){
        return sessionFactory.openSession();
    }
     
    public static void closeSession(Session session){
        if (session != null){
            if (session.isOpen()){
                session.close();
            }
        }
    }
}