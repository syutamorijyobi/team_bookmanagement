package dto;

public class AuthorDTO {
private int id;
private String author_name;
private String author_hiragana;
public AuthorDTO(int id, String author_name, String author_hiragana) {
	super();
	this.id = id;
	this.author_name = author_name;
	this.author_hiragana = author_hiragana;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAuthor_name() {
	return author_name;
}
public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}
public String getAuthor_hiragana() {
	return author_hiragana;
}
public void setAuthor_hiragana(String author_hiragana) {
	this.author_hiragana = author_hiragana;
}

}
