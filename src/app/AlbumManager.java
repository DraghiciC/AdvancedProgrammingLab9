package app;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistenceUtil;

public class AlbumManager {

	public static void main(String[] args) {
		//alc.create("Top songs", 3, 2010);
		//alc.create("Fum de taverna", 2, 2019);
		//alc.create("khoroshaya muzyka", 4, 2009)
		
		ArtistRepository ar = new ArtistRepository();
		AlbumRepository alr = new AlbumRepository();
		
		Artist art = new Artist("Mihai Alex", "Moldova");
		ar.create(art);
		art = new Artist("Mihai Margineanu", "Romania");
		ar.create(art);
		art = new Artist("Alexander", "America");
		ar.create(art);
		art = new Artist("Ivan Ivanovski", "Rusia");
		ar.create(art);
		
		art = ar.findById(2);
		System.out.print(art);
		
		List<Artist> artl = ar.findByName("Mihai");
		System.out.print("");
		for(Artist a : artl) {
			System.out.print(a);
		}

		System.out.print("");
		
		Album alb = new Album("Top songs", 3, 2010);
		alr.create(alb);
		alb = new Album("Fum de taverna", 2, 2019);
		alr.create(alb);
		alb = new Album("khoroshaya muzyka", 4, 2009);
		alr.create(alb);
		
		System.out.print("");
		
		alb = alr.findById(2);
		System.out.print(alb);
		
		
		List<Album> albl = alr.findByName("Fum");
		System.out.print("");
		for(Album a : albl) {
			System.out.print(a);
		}
		
		albl = alr.findByArtist(4);
		System.out.print("");
		for(Album a : albl) {
			System.out.print(a);
		}
		
	}

}
