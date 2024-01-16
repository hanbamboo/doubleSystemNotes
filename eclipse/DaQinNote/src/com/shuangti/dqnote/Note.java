package com.shuangti.dqnote;

public class Note {
	private String id;
	private String title;
	private String content;
	private boolean complete;
	private boolean love;
	private String editTime;
	private String type;

	public void createNote(String id, String title, String content, boolean complete, boolean love, String editTime,
			String type) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.complete = complete;
		this.love = love;
		this.editTime = editTime;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isLove() {
		return love;
	}

	public void setLove(boolean love) {
		this.love = love;
	}

	public String getEditTime() {
		return editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
