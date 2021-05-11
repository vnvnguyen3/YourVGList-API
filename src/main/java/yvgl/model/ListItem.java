package yvgl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;

@Entity
public class ListItem {
	
	public enum Priority {
		Low, Medium, High
	}
	
	public enum Status {
		Current, Continuously, Completed, OnHold, Dropped, Plan
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "list_item_id")
	private long list_item_id;
	
	@Range(min = 1, max = 10)
	private int rating;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public long getId() {
		return list_item_id;
	}

	public void setId(long list_item_id) {
		this.list_item_id = list_item_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public ListItem() {
		this(-1, 1, Priority.Low, Status.Plan);
	}

	public ListItem(long list_item_id, @Range(min = 1, max = 10) int rating, Priority priority, Status status) {
		super();
		this.list_item_id = list_item_id;
		this.rating = rating;
		this.priority = priority;
		this.status = status;
	}

	public ListItem(long list_item_id, @Range(min = 1, max = 10) int rating, Game game, User user, Priority priority, Status status) {
		super();
		this.list_item_id = list_item_id;
		this.rating = rating;
		this.game = game;
		this.user = user;
		this.priority = priority;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + list_item_id + ", rating=" + rating + ", game=" + game + ", user=" + user + ", priority="
				+ priority + ", status=" + status + "]";
	}
}
