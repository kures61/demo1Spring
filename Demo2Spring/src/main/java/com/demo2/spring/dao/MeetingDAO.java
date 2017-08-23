package com.demo2.spring.dao;

import java.util.List;

import com.demo2.spring.model.Meeting;

public interface MeetingDAO {
	
	public void saveOrUpdate(Meeting meeting);
	
	public String delete(int meetingId);
	
	public Meeting get(int meetingId);
	
	public List<Meeting> list();
	
}
