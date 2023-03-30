package dto;

public class User_ArticleDTO {
	private int id;
	private int user_id;
	private int isbn;
	private String content;
	private int  evaluation;
	private boolean  approval;
	
	public User_ArticleDTO(int id, int user_id, int isbn, String content, int evaluation, boolean approval) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.isbn = isbn;
		this.content = content;
		this.evaluation = evaluation;
		this.approval = approval;
		
		
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

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	
	
	
}
