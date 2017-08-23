package test.com.demo2.spring.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.demo2.spring.dao.UtilDAO;

public class UtulDAOTest {
	
	// jUnit examples : 

	@Test
	public void getDepartmentNameTest() {
		int deptId = 25;
		
		String result = UtilDAO.getDepartmentName(deptId);
		
		String excepted = "Matematik";
		Assert.assertEquals(excepted, result);        
	}   // getDepartmentNameTest
	
	@Test
	public void countDepartmentUseTest() {
		int deptId = 25;
		String tableName = "MEETING";
		
		int result = UtilDAO.countDepartmentUse(deptId, tableName );
		
		int excepted = 0;
		Assert.assertNotSame(excepted, result);      // 0 olmammasi beklenmekte        
	}   // getDepartmentNameTest	

}
