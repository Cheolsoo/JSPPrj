package com.newlecture.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String writerId;
	private Date regdate;
	private Integer hit;
	private String files;
	private String content;
	private boolean pub;

	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(int id, String title, String writerId, Date regdate, Integer hit, String files, String content, 
			boolean pub) {

		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.content = content;
		this.pub = pub;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
	
	// 20221026_1104
	// 기본적으로 boolean 형은 isPut() 와 같이 생성됩니다. 
	// 조금 불편해서 수작업으로 getPut 로 수정합니다. 
	// 
	//public boolean isPub() {
	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", writerId=" + writerId + ", regdate=" + regdate + ", hit="
				+ hit + ", files=" + files + ", content=" + content + ", pub=" + pub + "]";
	}

	
	
	
	
}
