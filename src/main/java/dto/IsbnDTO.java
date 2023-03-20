package dto;

public class IsbnDTO {
private int isbn;
private String titlel;
private int author_id;
private int publisher_id;
private int category_id;
public IsbnDTO(int isbn, String titlel, int author_id, int publisher_id, int category_id) {
	super();
	this.isbn = isbn;
	this.titlel = titlel;
	this.author_id = author_id;
	this.publisher_id = publisher_id;
	this.category_id = category_id;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getTitlel() {
	return titlel;
}
public void setTitlel(String titlel) {
	this.titlel = titlel;
}
public int getAuthor_id() {
	return author_id;
}
public void setAuthor_id(int author_id) {
	this.author_id = author_id;
}
public int getPublisher_id() {
	return publisher_id;
}
public void setPublisher_id(int publisher_id) {
	this.publisher_id = publisher_id;
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}

}
