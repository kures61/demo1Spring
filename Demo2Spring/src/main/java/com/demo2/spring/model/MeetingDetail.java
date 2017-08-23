package com.demo2.spring.model;

public class MeetingDetail {
	private int mtngDetailId;
    private int meetingId;
    private String meetingName;
    private int deptId;
    private String deptName;
    
	public MeetingDetail() {
		super();
	}

	public MeetingDetail(int mtngDetailId, int meetingId, String meetingName, int deptId, String deptName) {
		super();
		this.mtngDetailId = mtngDetailId;
		this.meetingId = meetingId;
		this.meetingName = meetingName;
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public int getMtngDetailId() {
		return mtngDetailId;
	}

	public void setMtngDetailId(int mtngDetailId) {
		this.mtngDetailId = mtngDetailId;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

    
	
}
