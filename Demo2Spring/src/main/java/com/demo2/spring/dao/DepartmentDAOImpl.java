package com.demo2.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.demo2.spring.model.Department;


public class DepartmentDAOImpl implements DepartmentDAO {

	private JdbcTemplate jdbcTemplate;
	
	public DepartmentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveOrUpdate(Department department) {
		if (department.getDeptId()> 0) {
			// update
			String sql = "UPDATE department SET name=?, description=? "
						+ " WHERE dept_id=?";
			jdbcTemplate.update(sql, department.getName(), department.getDescription(), department.getDeptId());
		} else {
			// insert
			PreparedStatement ps;
			try {
				ps = jdbcTemplate.getDataSource().getConnection().prepareStatement("insert into department (name, description) "
						+ "values(?, ?)",Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1,department.getName());
	            ps.setString(2,department.getDescription());	            
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

	public String delete(int departmentId) {
		String errorDesc = "OK";
		if ( UtilDAO.countDepartmentUse(departmentId, "MEETING") > 0 ){
			errorDesc = "NOT - Contraint Error";
		} else if ( UtilDAO.countDepartmentUse(departmentId, "EMPLOYEE") > 0 ){
			errorDesc = "NOT - Contraint Error";
		} else {
			String sql = "DELETE FROM department WHERE dept_id=?";
			jdbcTemplate.update(sql, departmentId);
		}
		return errorDesc;
	}

	
	public Department get(int departmentId) {
		String sql = "SELECT * FROM department WHERE dept_id=" + departmentId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {
			
			public Department extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				if (rs.next()) {
					Department department = new Department();
					department.setDeptId(rs.getInt("dept_id"));
					department.setName(rs.getString("name"));
					department.setDescription(rs.getString("description"));
					return department;
				}				
				return null;
			}			
		  }
		);
	}

	
	public List<Department> list() {
		String sql = "SELECT * FROM department";
		List<Department> listDepartment = jdbcTemplate.query(sql, new RowMapper<Department>() {

			
			public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
				Department department = new Department();	
				department.setDeptId(rs.getInt("dept_id"));
				department.setName(rs.getString("name"));
				department.setDescription(rs.getString("description"));
				return department;
			}
			
		});
		
		return listDepartment;
	}



}
