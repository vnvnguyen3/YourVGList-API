package yvgl.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public enum ESRB {
		E, E10, T, M, Ao
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "game_id")
	private long id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	private String description;
	
	private String platform;
	
	private String developer;
	
	private String publisher;
	
	private String genre;
	
	private Date release;
	
	@Enumerated(EnumType.STRING)
	private ESRB esrb;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public ESRB getEsrb() {
		return esrb;
	}

	public void setEsrb(ESRB esrb) {
		this.esrb = esrb;
	}
	
	public Game() {
		this(0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", new Date(System.currentTimeMillis()), ESRB.E);
	}

	public Game(long id, String title, String description, String platform, String developer, String publisher, String genre, Date release,
			ESRB esrb) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.platform = platform;
		this.developer = developer;
		this.publisher = publisher;
		this.genre = genre;
		this.release = release;
		this.esrb = esrb;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", platform=" + platform
				+ ", developer=" + developer + ", publisher=" + publisher + ", genre=" + genre + ", release=" + release
				+ ", esrb=" + esrb + "]";
	}
}
