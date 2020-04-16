package entity;

import javax.persistence.*;

@Entity
@Table(name="ARTISTS")

@org.hibernate.annotations.NamedQuery(name = "FnByNa1", query = "from Artist where name like :numeCautat")
public class Artist {

	@Id
	@Column(name="ID")
	private int id=0;
	
	@Column(name="NAME")
	private String name;

	@Column(name="COUNTRY")
	private String country;

	public Artist() {
		
	}

	public Artist(String nume, String country) {
		this.name = nume;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return name;
	}

	public void setNume(String nume) {
		this.name = nume;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Artists [id=" + id + ", nume=" + name + ", country=" + country + "]";
	}
}
