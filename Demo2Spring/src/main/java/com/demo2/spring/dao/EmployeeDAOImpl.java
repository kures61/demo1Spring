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

import com.demo2.spring.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveOrUpdate(Employee employee) {
		if (employee.getEmpId()> 0) {
			// update
			String sql = "UPDATE Employee SET name=?, surname=?, salary=?, dept_id=? "
						+ " WHERE emp_id=?";
			jdbcTemplate.update(sql, employee.getName(), employee.getSurname(), employee.getSalary(), employee.getDeptId(), employee.getEmpId());
		} else {
			//employee.write();
			// insert
			PreparedStatement ps;
			try {
				ps = jdbcTemplate.getDataSource().getConnection().prepareStatement("insert into Employee (name, surname, salary, dept_id) "
						+ "values(?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1,employee.getName());
	            ps.setString(2,employee.getSurname());
	            ps.setInt(3,employee.getSalary());
	            ps.setInt(4,employee.getDeptId());	            
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

	public void delete(int empId) {
		String sql = "DELETE FROM Employee WHERE emp_id=?";
		jdbcTemplate.update(sql, empId);		
	}

	
	public Employee get(int empId) {
		String sql = "SELECT * FROM Employee WHERE emp_id=" + empId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {			
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException 
			{
				if (rs.next()) {
					Employee employee = new Employee();
					employee.setEmpId(rs.getInt("emp_id"));
					employee.setName(rs.getString("name"));
					employee.setSurname(rs.getString("surname"));
					employee.setSalary(rs.getInt("salary"));
					employee.setDeptId(rs.getInt("dept_id"));
					return employee;
				}				
				return null;
			}			
		  }
		);
	}
	
	public List<Employee> list() {
		String sql = "SELECT * FROM Employee";
		List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {
			
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmpId(rs.getInt("emp_id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));
				employee.setSalary(rs.getInt("salary"));
				employee.setDeptId(rs.getInt("dept_id"));
				employee.setDeptName(UtilDAO.getDepartmentName(rs.getInt("dept_id")));  // JSF lerde goruntulemek icin
				return employee;
			}			
		});		
		return listEmployee;
	}

}
