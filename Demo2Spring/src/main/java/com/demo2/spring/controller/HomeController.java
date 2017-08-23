package com.demo2.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo2.spring.dao.DepartmentDAO;
import com.demo2.spring.dao.EmployeeDAO;
import com.demo2.spring.dao.MeetingDAO;
import com.demo2.spring.dao.MeetingDetailDAO;
import com.demo2.spring.dao.UtilDAO;
import com.demo2.spring.model.Department;
import com.demo2.spring.model.Employee;
import com.demo2.spring.model.Meeting;
import com.demo2.spring.model.MeetingDetail;


@Controller
public class HomeController {



	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private MeetingDAO meetingDAO;
	
	@Autowired
	private MeetingDetailDAO meetingDetailDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listDepartment(ModelAndView model) throws IOException{
		List<Department> listDepartment = departmentDAO.list();
		model.addObject("listDepartment", listDepartment);
		model.addObject("errorDesc", "");
		model.setViewName("department");
		return model;
	}
	
	@RequestMapping(value="/lstDepartment")
	public ModelAndView lstDepartment(ModelAndView model) throws IOException{
		List<Department> listDepartment = departmentDAO.list();
		model.addObject("listDepartment", listDepartment);
		model.addObject("errorDesc", "");		
		model.setViewName("department");		
		return model;
	}	

	@RequestMapping(value="/lstDepartmentErr")
	public ModelAndView lstDepartmentErr(ModelAndView model) throws IOException{
		List<Department> listDepartment = departmentDAO.list();
		model.addObject("listDepartment", listDepartment);
		model.addObject("errorDesc", "Error : Delete is not OK.");		
		model.setViewName("department");		
		return model;
	}	
	
	//----------------------

	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute Department department) {
		departmentDAO.saveOrUpdate(department);		
		return new ModelAndView("redirect:/lstDepartment");
	}
	
	@RequestMapping(value = "/newDepartment", method = RequestMethod.GET)
	public ModelAndView newDepartment(ModelAndView model) {
		Department newDepartment = new Department();
		model.addObject("department", newDepartment);
		model.addObject("errorDesc", "");
		model.setViewName("departmentForm");
		return model;
	}
	
	@RequestMapping(value = "/editDepartment", method = RequestMethod.GET)
	public ModelAndView editDepartment(HttpServletRequest request) {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Department department = departmentDAO.get(deptId);
		ModelAndView model = new ModelAndView("departmentForm");
		model.addObject("department", department);
		model.addObject("errorDesc", "");
		return model;
	}

	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(HttpServletRequest request) {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String errorDescription = departmentDAO.delete(deptId);
		if ( !errorDescription.equals("OK") ){
			return new ModelAndView("redirect:/lstDepartmentErr");
		} else {
			return new ModelAndView("redirect:/lstDepartment");
		}
		
	}

	//---------------------- Employee :

	@RequestMapping(value = "/listEmployee", method = RequestMethod.GET)
	public ModelAndView listEmployee(ModelAndView model) {
		List<Employee> listEmployee = employeeDAO.list();
		model.addObject("listEmployee", listEmployee);
		model.addObject("errorDesc", "");
		model.setViewName("employee");		
		return model;
	}			

	@RequestMapping(value = "/listEmployeeErr", method = RequestMethod.GET)
	public ModelAndView listEmployeeErr(ModelAndView model) {
		List<Employee> listEmployee = employeeDAO.list();
		model.addObject("listEmployee", listEmployee);
		model.addObject("errorDesc", "");
		model.setViewName("employee");		
		return model;
	}	
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		employeeDAO.saveOrUpdate(employee);		
		return new ModelAndView("redirect:/listEmployee");
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmployee = new Employee();
		model.addObject("employee", newEmployee);
		model.addObject("deptsAll", UtilDAO.findAllDepartment());
		model.addObject("errorDesc", "");
		model.setViewName("employeeForm");
		return model;
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		Employee employee = employeeDAO.get(empId);
		ModelAndView model = new ModelAndView("employeeForm");
		model.addObject("employee", employee);
		model.addObject("deptsAll", UtilDAO.findAllDepartment());
		return model;
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int empId = Integer.parseInt(request.getParameter("empId"));
		employeeDAO.delete(empId);
		return new ModelAndView("redirect:/listEmployee");
	}
	
	//---------------------- Meeting	

	@RequestMapping(value = "/listMeeting", method = RequestMethod.GET)
	public ModelAndView listMeeting(ModelAndView model) {
		List<Meeting> listMeeting = meetingDAO.list();
		model.addObject("listMeeting", listMeeting);
		model.addObject("errorDesc", "");
		model.setViewName("meeting");		
		return model;
	}			

	@RequestMapping(value = "/listMeetingErr", method = RequestMethod.GET)
	public ModelAndView listMeetingErr(ModelAndView model) {
		List<Meeting> listMeeting = meetingDAO.list();
		model.addObject("listMeeting", listMeeting);		
		model.addObject("errorDesc", "Error : Delete is not OK.");
		model.setViewName("meeting");		
		return model;
	}		
	
	@RequestMapping(value = "/saveMeeting", method = RequestMethod.POST)
	public ModelAndView saveMeeting(@ModelAttribute Meeting meeting) {
		meetingDAO.saveOrUpdate(meeting);		
		return new ModelAndView("redirect:/listMeeting");
	}
	
	@RequestMapping(value = "/newMeeting", method = RequestMethod.GET)
	public ModelAndView newMeeting(ModelAndView model) {
		Meeting newMeeting = new Meeting();
		model.addObject("meeting", newMeeting);
		model.addObject("errorDesc", "");
		model.setViewName("meetingForm");
		return model;
	}

	@RequestMapping(value = "/editMeeting", method = RequestMethod.GET)
	public ModelAndView editMeeting(HttpServletRequest request) {
		int mtngId= Integer.parseInt(request.getParameter("mtngId"));
		Meeting meeting = meetingDAO.get(mtngId);
		ModelAndView model = new ModelAndView("meetingForm");
		model.addObject("meeting", meeting);
		model.addObject("errorDesc", "");
		return model;
	}

	@RequestMapping(value = "/deleteMeeting", method = RequestMethod.GET)
	public ModelAndView deleteMeeting(HttpServletRequest request) {
		int mtngId= Integer.parseInt(request.getParameter("mtngId"));
		String errorDescription = meetingDAO.delete(mtngId);
		if ( !errorDescription.equals("OK") ){
			return new ModelAndView("redirect:/listMeetingErr");
		} else {
			return new ModelAndView("redirect:/listMeeting");
		}		
	}
	
	//---------------------- Meeting Detail

	@RequestMapping(value = "/listMeetingDetail", method = RequestMethod.GET)
	public ModelAndView listMeetingDetail(ModelAndView model) {
		List<MeetingDetail> listMeetingDetail =  meetingDetailDAO.list();
		model.addObject("listMeetingDetail", listMeetingDetail);
		model.addObject("errorDesc", "");
		model.setViewName("meetingDetail");		
		return model;
	}	

	@RequestMapping(value = "/listMeetingDetailErr", method = RequestMethod.GET)
	public ModelAndView listMeetingDetailErr(ModelAndView model) {
		List<MeetingDetail> listMeetingDetail =  meetingDetailDAO.list();
		model.addObject("listMeetingDetail", listMeetingDetail);
		model.addObject("errorDesc", "Error : DB Operation is not OK.");
		model.setViewName("meetingDetail");		
		return model;
	}		

	@RequestMapping(value = "/saveMeetingDetail", method = RequestMethod.POST)
	public ModelAndView saveMeetingDetail(@ModelAttribute MeetingDetail meetingDetail) {
		String errDesc = meetingDetailDAO.saveOrUpdate(meetingDetail);	
		if ( !errDesc.equals("OK") ) {
			return new ModelAndView("redirect:/listMeetingDetailErr");
		} else {
			return new ModelAndView("redirect:/listMeetingDetail");
		}
		
	}	
	
	@RequestMapping(value = "/newMeetingDetail", method = RequestMethod.GET)
	public ModelAndView newMeetingDetail(ModelAndView model) {
		MeetingDetail newMeetingDetail = new MeetingDetail();
		model.addObject("meetingDetail", newMeetingDetail);
		model.addObject("deptsAll", UtilDAO.findAllDepartment());
		model.addObject("meetsAll", UtilDAO.findAllMeeting());
		model.addObject("errorDesc", "");
		model.setViewName("meetingDetailForm");
		return model;
	}
	
	@RequestMapping(value = "/deleteMeetingDetail", method = RequestMethod.GET)
	public ModelAndView deleteMeetingDetail(HttpServletRequest request) {
		int mtngDetId= Integer.parseInt(request.getParameter("mtngDetId"));
		String errorDescription = meetingDetailDAO.delete(mtngDetId);
		return new ModelAndView("redirect:/listMeetingDetail");
	}
		
	
	
}
