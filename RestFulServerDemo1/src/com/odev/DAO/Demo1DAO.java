package com.odev.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.odev.DB.odevDB;
import com.odev.entity.Department;
import com.odev.entity.DepartmentEmp;
import com.odev.entity.Employee;

/*
 * @author Lokman
 */
public class Demo1DAO {
	
    public static Department getDepartment(int deptId){
        Department department = new Department();
        if (deptId > 0) {
            Connection con = odevDB.getMySqlConneciton();
            String sql = "select * FROM `department` where `dept_id` = ? ";
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, deptId);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    department = new Department(rs.getInt("dept_id"), rs.getString("name"), rs.getString("description"));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return department;
            }
        }
        return department;
    }  // end of getDepartment

    public static List<Department> getDepartmentList(){
        List<Department> allDepartment = new ArrayList<Department>();
        Connection con = odevDB.getMySqlConneciton();
        String sql = "SELECT `dept_id`,`name`,`description` FROM `department` order by `dept_id`  ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                    Department department = new Department(rs.getInt("dept_id"),rs.getString("name"),rs.getString("description"));
                    allDepartment.add(department);
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
        return allDepartment;
    }  // end of getDepartmentList
    
    public static List<DepartmentEmp> getDepartmentEmpList(){
        List<DepartmentEmp> allDepartmentEmp = new ArrayList<DepartmentEmp>();
        Connection con = odevDB.getMySqlConneciton();
        String sql = "SELECT `dept_id`,`name`,`description` FROM `department` order by `dept_id`  ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                    DepartmentEmp departmentEmp = new DepartmentEmp(rs.getInt("dept_id"),rs.getString("name"),rs.getString("description"));
                    List<Employee> empList = getEmployeeList(rs.getInt("dept_id"));
                    departmentEmp.setEmployeeList(empList);
                    allDepartmentEmp.add(departmentEmp);
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
        return allDepartmentEmp;
    }  // end of getDepartmentEmpList    

    public static List<Employee> getEmployeeList(int deptId){
        List<Employee> allEmployee = new ArrayList<Employee>();
        
        Connection con = odevDB.getMySqlConneciton();
        String sql = "SELECT `emp_id`,`name`,`surname`,`salary`,`dept_id` FROM `employee` where `dept_id` = ? order by `emp_id`  ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ){
                while ( rs.next()) {
                    Employee employee = new Employee(rs.getInt("emp_id"),rs.getString("name"),rs.getString("surname"),rs.getInt("salary"), rs.getInt("dept_id"));
                    allEmployee.add(employee);
                }    
            }            
        }  catch (Exception e) {
            e.printStackTrace();
        }          
        return allEmployee;
    }  // end of getEmployeeList
    
    public static int insertDepartment(int deptId, String name, String desc){
        Connection con = odevDB.getMySqlConneciton();
        String sql = "insert into `department` ( `name`,`description`, `dept_id` ) values (?, ?, ? ) ";
        int id1 = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setInt(3, deptId);
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
			if (rs.next()) {
				id1 = rs.getInt(1);
			}
        }  catch (Exception e) {
            e.printStackTrace();
            return 0;
        }          
        return id1;
    }  // end of insertDepartment
    
}
