package repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Artist;
import util.PersistenceUtil;

public class ArtistRepository {
	PersistenceUtil persUtil = PersistenceUtil.getInstance();
	SessionFactory factory = persUtil.getFactory();
	Session session;
	public void create(Artist art) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(art);
		session.getTransaction().commit();
	}
	public Artist findById(int n) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		Artist art = session.get(Artist.class,n);
		session.getTransaction().commit();
		return art;
	}
	
public List<Artist> findByName(String n) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		List<Artist> art = session.createNamedQuery("FnByNa1", Artist.class).setParameter("numeCautat", n + "%").getResultList();
		//List<Artists> art = session.createQuery("from Artists s where s.nume LIKE '" + n + "%'").getResultList();
		session.getTransaction().commit();
		return art;
	}
}
