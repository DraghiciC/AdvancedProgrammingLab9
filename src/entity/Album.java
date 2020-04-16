package entity;

import javax.persistence.*;

@Entity
@Table(name="ALBUMS")

@org.hibernate.annotations.NamedQuery(name = "FnByNa2", 
query = "from Album where nume like :numeCautat")
@org.hibernate.annotations.NamedQuery(name = "FnByAr", 
query = "from Album where artist_id = :idCautat")
public class Album {

	@Id
	@Column(name="ID")
	private int id=0;
	
	@Column(name="NAME")
	private String nume;

	@Column(name="ARTIST_ID")
	private int artist_id;
	
	@Column(name="RELEASE_YEAR")
	private int release_year;

	public Album() {
	}
	public Album(String nume, int artist_id, int release_year) {
		this.nume = nume;
		this.artist_id = artist_id;
		this.release_year = release_year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	@Override
	public String toString() {
		return "Albums [id=" + id + ", nume=" + nume + ", artist_id=" + artist_id + ", release_year=" + release_year
				+ "]";
	}
}
