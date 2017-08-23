package com.demo2.spring.dao;

import java.util.List;

import com.demo2.spring.model.Meeting;
import com.demo2.spring.model.MeetingDetail;

public interface MeetingDetailDAO {
	
	public String saveOrUpdate(MeetingDetail meetingDetail);
	
	public String delete(int meetingDetailId);
	
	public MeetingDetail get(int meetingDetailId);
	
	public List<MeetingDetail> list();
	
}
