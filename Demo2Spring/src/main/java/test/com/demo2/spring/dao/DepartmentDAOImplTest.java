package test.com.demo2.spring.dao;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import com.demo2.spring.config.MvcConfiguration;
import com.demo2.spring.dao.DepartmentDAOImpl;
import com.demo2.spring.model.Department;

public class DepartmentDAOImplTest {

	// jUnit examples : 
	
	@Test
	public void deleteTest() {
		int deptId = 25;
		MvcConfiguration mv = new MvcConfiguration();
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(mv.getDataSource());
		String result = departmentDAOImpl.delete(deptId);
		
		String excepted = "OK";
		
		Assert.assertNotSame(excepted, result);    // OK olmamali - kullanilan veri    
	}   // deleteTest
	
	@Test
	public void getTest() {
		int deptId = 25;
		MvcConfiguration mv = new MvcConfiguration();
        DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl(mv.getDataSource());
        Department result = departmentDAOImpl.get(deptId);
		
		Department excepted = new Department();
		excepted.setDeptId(25);
		excepted.setName("Matematik");
		excepted.setDescription("Matematik Ana Bilim Dalý");
		
		Assert.assertSame(excepted.getName(), result.getName());        
	}   // deleteTest
	
	
}
