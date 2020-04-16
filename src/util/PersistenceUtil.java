package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Album;
import entity.Artist;

public class PersistenceUtil {

    private static PersistenceUtil factory;
    public SessionFactory fact;
    PersistenceUtil() {
    	fact =  new Configuration()
    			.configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Artist.class)
    			.addAnnotatedClass(Album.class)
    			.buildSessionFactory();
    }

    public static PersistenceUtil getInstance() {
        if (factory == null) {
        	factory = new PersistenceUtil();
        }
        return factory;
    }
    public SessionFactory getFactory() {
    	return fact;
    }
}