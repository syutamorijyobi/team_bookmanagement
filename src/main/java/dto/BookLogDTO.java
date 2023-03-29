package dto;

import java.sql.Timestamp;

public class BookLogDTO {
	private int id;
	private int user_id;
	private int division_id;
	private int book_id;
	private Timestamp deadline_at;
	private Timestamp lending_at;
	private Timestamp return_at;
	public BookLogDTO(int id, int user_id, int division_id, int book_id, Timestamp deadline_at, Timestamp lending_at,
			Timestamp return_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.division_id = division_id;
		this.book_id = book_id;
		this.deadline_at = deadline_at;
		this.lending_at = lending_at;
		this.return_at = return_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDivision_id() {
		return division_id;
	}
	public void setDivision_id(int division_id) {
		this.division_id = division_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public Timestamp getDeadline_at() {
		return deadline_at;
	}
	public void setDeadline_at(Timestamp deadline_at) {
		this.deadline_at = deadline_at;
	}
	public Timestamp getLending_at() {
		return lending_at;
	}
	public void setLending_at(Timestamp lending_at) {
		this.lending_at = lending_at;
	}
	public Timestamp getReturn_at() {
		return return_at;
	}
	public void setReturn_at(Timestamp return_at) {
		this.return_at = return_at;
	}
	
}
