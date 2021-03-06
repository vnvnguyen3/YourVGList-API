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
	private long game_id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	private String description;
	
	private String platform;
	
	private String developer;
	
	private String publisher;
	
	private String genre;
	
	private Date releaseDate;
	
	@Enumerated(EnumType.STRING)
	private ESRB esrb;

	public long getId() {
		return game_id;
	}

	public void setId(long game_id) {
		this.game_id = game_id;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setRelease(Date releaseDate) {
		this.releaseDate = releaseDate;
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

	public Game(long game_id, String title, String description, String platform, String developer, String publisher, String genre, Date releaseDate,
			ESRB esrb) {
		super();
		this.game_id = game_id;
		this.title = title;
		this.description = description;
		this.platform = platform;
		this.developer = developer;
		this.publisher = publisher;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.esrb = esrb;
	}

	@Override
	public String toString() {
		return "Game [id=" + game_id + ", title=" + title + ", description=" + description + ", platform=" + platform
				+ ", developer=" + developer + ", publisher=" + publisher + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ ", esrb=" + esrb + "]";
	}
}
