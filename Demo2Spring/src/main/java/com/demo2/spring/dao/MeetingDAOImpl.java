package com.demo2.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.demo2.spring.model.Meeting;


public class MeetingDAOImpl implements MeetingDAO {

	private JdbcTemplate jdbcTemplate;
	
	public MeetingDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveOrUpdate(Meeting meeting) {
		if (meeting.getMtngId()> 0) {
			// update
			String sql = "UPDATE meeting SET name=?, description=? "
						+ " WHERE mtng_id=?";
			jdbcTemplate.update(sql, meeting.getName(), meeting.getDescription(), meeting.getMtngId());
		} else {
			// insert
			PreparedStatement ps;
			try {
				ps = jdbcTemplate.getDataSource().getConnection().prepareStatement("insert into meeting (name, description) "
						+ "values(?, ?)",Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1,meeting.getName());
	            ps.setString(2,meeting.getDescription());	            
	            ps.executeUpdate();
	            ResultSet rs=ps.getGeneratedKeys();
	            if(rs.next()){
	                int id1=rs.getInt(1);
	            }
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	public String delete(int meetingId) {
		String errorDesc = "OK";
		if ( UtilDAO.countMeetingUse(meetingId, "MEETING") > 0 ){
			errorDesc = "NOT - Contraint Error";	
		} else {
			String sql = "DELETE FROM meeting WHERE mtng_id=?";
			jdbcTemplate.update(sql, meetingId);		
		}
		return errorDesc;
	}

	
	public Meeting get(int meetingId) {
		String sql = "SELECT * FROM meeting WHERE mtng_id=" + meetingId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Meeting>() {
			
			public Meeting extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				if (rs.next()) {
					Meeting meeting = new Meeting();
					meeting.setMtngId(rs.getInt("mtng_id"));
					meeting.setName(rs.getString("name"));
					meeting.setDescription(rs.getString("description"));
					return meeting;
				}				
				return null;
			}	
			
		  }
		);
	}

	
	public List<Meeting> list() {
		String sql = "SELECT * FROM meeting ";
		List<Meeting> listMeeting = jdbcTemplate.query(sql, new RowMapper<Meeting>() {

			public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
				Meeting meeting = new Meeting();	
				meeting.setMtngId(rs.getInt("mtng_id"));
				meeting.setName(rs.getString("name"));
				meeting.setDescription(rs.getString("description"));
				return meeting;
			}
			
		});
		
		return listMeeting;
	}


}
