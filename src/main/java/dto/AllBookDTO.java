package dto;

public class AllBookDTO {
private int id;
private int isbn;
private String title;
private String author;
private String publisher;
private String category;
private boolean condition;
private String status;
public AllBookDTO(int id, int isbn, String title, String author, String publisher, String category, boolean condition,
		String status) {
	super();
	this.id = id;
	this.isbn = isbn;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.category = category;
	this.condition = condition;
	this.status = status;
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
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public boolean isCondition() {
	return condition;
}
public void setCondition(boolean condition) {
	this.condition = condition;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
