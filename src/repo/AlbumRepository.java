package repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Album;
import util.PersistenceUtil;

public class AlbumRepository {
	PersistenceUtil persUtil = PersistenceUtil.getInstance();
	SessionFactory factory = persUtil.getFactory();
	Session session;
	public void create(Album alb) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(alb);
		session.getTransaction().commit();
	}
	public Album findById(int n) {
		session = factory.getCurrentSession();
		session.beginTransaction();
		Album art = session.get(Album.class,n);
		session.getTransaction().commit();
		return art;
	}
	
public List<Album> findByName(String n) {
	session = factory.getCurrentSession();
		session.beginTransaction();
		List<Album> art = session.createNamedQuery("FnByNa2", Album.class).setParameter("numeCautat", n + "%").getResultList();
		//List<Artists> art = session.createQuery("from Artists s where s.nume LIKE '" + n + "%'").getResultList();
		session.getTransaction().commit();
		return art;
	}
public List<Album> findByArtist(int n) {
	session = factory.getCurrentSession();
	session.beginTransaction();
	List<Album> art = session.createNamedQuery("FnByAr", Album.class).setParameter("idCautat", n).getResultList();
	session.getTransaction().commit();
	return art;
}
}
