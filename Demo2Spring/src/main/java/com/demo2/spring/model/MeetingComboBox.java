package com.demo2.spring.model;

public class MeetingComboBox {
    private int metId;
    private String metName;

    public MeetingComboBox() {
		super();
	}

	public MeetingComboBox(int metId, String metName) {
		super();
		this.metId = metId;
		this.metName = metName;
	}

	public int getMetId() {
		return metId;
	}

	public void setMetId(int metId) {
		this.metId = metId;
	}

	public String getMetName() {
		return metName;
	}

	public void setMetName(String metName) {
		this.metName = metName;
	}


    
	
}
