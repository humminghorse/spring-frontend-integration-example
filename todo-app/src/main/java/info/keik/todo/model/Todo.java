package info.keik.todo.model;

public class Todo {

	private Long id;
	private String title;
	private Boolean complete;

	public Todo() {
	}

	public Todo(Long id, String title, Boolean complete) {
		this.id = id;
		this.title = title;
		this.complete = complete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

}
