package dto;

import java.sql.Timestamp;

public class BookDTO {
private int id;
private int isbn;
private String status;
private boolean condition;
private Timestamp time;
public BookDTO(int id, int isbn, String status, boolean condition, Timestamp time) {
	super();
	this.id = id;
	this.isbn = isbn;
	this.status = status;
	this.condition = condition;
	this.time = time;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public boolean isCondition() {
	return condition;
}
public void setCondition(boolean condition) {
	this.condition = condition;
}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}

}
