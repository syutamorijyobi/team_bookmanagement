package dto;

public class PublisherDTO {
	private int id;
	private String publisher_name;
	private String publisher_hiragana;
	public PublisherDTO(int id, String publisher_name, String publisher_hiragana) {
		super();
		this.id = id;
		this.publisher_name = publisher_name;
		this.publisher_hiragana = publisher_hiragana;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public String getPublisher_hiragana() {
		return publisher_hiragana;
	}
	public void setPublisher_hiragana(String publisher_hiragana) {
		this.publisher_hiragana = publisher_hiragana;
	}
	
}
