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

import com.demo2.spring.model.MeetingDetail;


public class MeetingDetailDAOImpl implements MeetingDetailDAO {

	private JdbcTemplate jdbcTemplate;
	
	public MeetingDetailDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String saveOrUpdate(MeetingDetail meetingDetail) {
		String errorDesc = "OK";
		if (meetingDetail.getMtngDetailId()> 0) {
			// update
			String sql = "UPDATE meeting_detay SET mtng_id=?, dept_id=? "
						+ " WHERE mtng_dty_id=?";
			jdbcTemplate.update(sql, meetingDetail.getMeetingId(), meetingDetail.getDeptId(), meetingDetail.getMtngDetailId());
		} else {
			// insert
			int countData = UtilDAO.countMeetingDetailUse(meetingDetail.getMeetingId(), meetingDetail.getDeptId());
			if ( countData > 0 ) {
				errorDesc = "Insert is not OK.";
			} else {
				PreparedStatement ps;
				try {
					ps = jdbcTemplate.getDataSource().getConnection().prepareStatement("insert into meeting_detay (mtng_id, dept_id) "
							+ "values(?, ?)",Statement.RETURN_GENERATED_KEYS);
		            ps.setInt(1,meetingDetail.getMeetingId());
		            ps.setInt(2,meetingDetail.getDeptId());	            
		            ps.executeUpdate();
		            ResultSet rs=ps.getGeneratedKeys();
		            if(rs.next()){
		                int id1=rs.getInt(1);
		            }
		            
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}  // if ( countData == 0 ) 
		}
		return errorDesc ;
	}

	public String delete(int meetingDetailId) {
		String errorDesc = "OK";
			String sql = "DELETE FROM meeting_detay WHERE mtng_dty_id=?";
			jdbcTemplate.update(sql, meetingDetailId);		
		return errorDesc;
	}

	
	public MeetingDetail get(int meetingDetailId) {
		String sql = "select md.mtng_dty_id, md.mtng_id, m.name as meet_name, d.dept_id, d.name as dept_name "
				+ " from `meeting` m, `meeting_detay` md, `department` d"
				+ " where md.mtng_id =m.mtng_id and d.dept_id=md.dept_id and md.mtng_dty_id=" + meetingDetailId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<MeetingDetail>() {
			
			public MeetingDetail extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				if (rs.next()) {
					MeetingDetail meetingDetail = new MeetingDetail();
					meetingDetail.setMtngDetailId(rs.getInt("mtng_dty_id"));
					meetingDetail.setMeetingId(rs.getInt("mtng_id"));
					meetingDetail.setMeetingName(rs.getString("meet_name"));
					meetingDetail.setDeptId(rs.getInt("dept_id"));
					meetingDetail.setDeptName(rs.getString("dept_name"));
					return meetingDetail;
				}				
				return null;
			}	
			
		  }
		);
	}

	
	public List<MeetingDetail> list() {
		String sql = "select md.mtng_dty_id, md.mtng_id, m.name as meet_name, d.dept_id, d.name as dept_name "
				+ " from `meeting` m, `meeting_detay` md, `department` d "
				+ " where md.mtng_id =m.mtng_id and d.dept_id=md.dept_id "
				+ " order by m.mtng_id, d.dept_id ";
		List<MeetingDetail> listMeetingDetail = jdbcTemplate.query(sql, new RowMapper<MeetingDetail>() {

			public MeetingDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				MeetingDetail meetingDetail = new MeetingDetail();	
				meetingDetail.setMtngDetailId(rs.getInt("mtng_dty_id"));
				meetingDetail.setMeetingId(rs.getInt("mtng_id"));
				meetingDetail.setMeetingName(rs.getString("meet_name"));
				meetingDetail.setDeptId(rs.getInt("dept_id"));
				meetingDetail.setDeptName(rs.getString("dept_name"));
				return meetingDetail;
			}
			
		});
		
		return listMeetingDetail;
	}


}
