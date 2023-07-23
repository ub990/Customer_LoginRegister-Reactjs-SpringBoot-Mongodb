package com.example.SpringBoot_Code.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_Sequence")

public class DbSequence {
	
	@Id
	private String id;
	private int seq;
	
	public DbSequence() {}
	
	public DbSequence(String id, int seq) {
		super();
		this.id=id;
		this.seq=seq;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
