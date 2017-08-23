package com.demo2.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.demo2.spring.config.MvcConfiguration;
import com.demo2.spring.model.DepartmentComboBox;
import com.demo2.spring.model.MeetingComboBox;
import com.demo2.spring.model.MeetingDetail;

public class UtilDAO {

	private JdbcTemplate jdbcTemplate;
	
	public static List<DepartmentComboBox> findAllDepartment(){
		List<DepartmentComboBox> depts = new ArrayList<DepartmentComboBox>();
		
        String sql = "SELECT `dept_id`,`name` FROM `department` order by `dept_id`  ";
        try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	DepartmentComboBox department = new DepartmentComboBox(rs.getInt("dept_id"),rs.getString("name"));
                	depts.add(department);
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return depts;
	}
	
	public static List<MeetingComboBox> findAllMeeting(){
		List<MeetingComboBox> listMeetingComboBox = new ArrayList<MeetingComboBox>();
		
        String sql = "SELECT mtng_id, name from `meeting` order by mtng_id  ";
        try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	MeetingComboBox meetingComboBox = new MeetingComboBox(rs.getInt("mtng_id"),rs.getString("name"));
                	listMeetingComboBox.add(meetingComboBox);
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return listMeetingComboBox;
	}	
	public static String getDepartmentName(int deptId){
		String deptName  = "";
		String sql = "SELECT name FROM `department` WHERE `dept_id`=?  ";
		try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	deptName = rs.getString("name");
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return deptName;
	}  // end of getDepartmentName

	public static int countDepartmentUse(int deptId, String tableName){
		String sql = "";
		int countData = 0;
		if ( tableName.equals("MEETING") ){
			sql = "SELECT count(*) as CNT FROM `meeting_detay` WHERE `dept_id`=?  ";
		} else {
			sql = "SELECT count(*) as CNT FROM `employee` WHERE `dept_id`=?  ";
		}   
        try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	countData = rs.getInt("CNT");
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return countData;
	}  // end of countDepartmentUse

	public static int countMeetingUse(int mtngId, String tableName){
		String sql = "";
		int countData = 0;
		//if ( tableName.equals("MEETING") ){
			sql = "SELECT count(*) as CNT FROM `meeting_detay` WHERE `mtng_id` = ?  ";
		//}   
        try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mtngId);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	countData = rs.getInt("CNT");
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return countData;
	}  // end of countMeetingUse
	
	
	
	public static int countMeetingDetailUse(int mtngId, int deptId){
		String sql = "";
		int countData = 0;
		//if ( tableName.equals("MEETING") ){
			sql = "select count(*) as CNT FROM `meeting_detay` where `mtng_id`=? and `dept_id`=? ";
		//}   
        try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mtngId);
            ps.setInt(2, deptId);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	countData = rs.getInt("CNT");
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return countData;
	}  // end of countMeetingDetailUse			
	
	public static List<MeetingDetail> getListMeetingDetail(){
		List<MeetingDetail> listMeetingDetail = new ArrayList<MeetingDetail>();
		
        String sql = " select md.mtng_dty_id, md.mtng_id, m.name as meet_name, d.dept_id, d.name as dept_name "
        		+ " from `meeting` m, `meeting_detay` md, `department` d "
        		+ " where md.mtng_id =m.mtng_id and d.dept_id=md.dept_id"
        		+ " order by m.mtng_id, d.dept_id ";
        try {
        	MvcConfiguration mv = new MvcConfiguration();
            Connection con = mv.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                	MeetingDetail meetingDetail = new MeetingDetail(rs.getInt("mtng_dty_id")
                			        ,rs.getInt("mtng_id")
                			        ,rs.getString("meet_name")
                			        ,rs.getInt("dept_id")
                			        ,rs.getString("dept_name")                			        
                			        );
                	listMeetingDetail.add(meetingDetail);
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
		return listMeetingDetail;
	}	// getListMeetingDetail
	
}
