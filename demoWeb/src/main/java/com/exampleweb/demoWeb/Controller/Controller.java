package com.exampleweb.demoWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exampleweb.demoWeb.Entity.Employee;
import com.exampleweb.demoWeb.Service.EmployeeService;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	EmployeeService empService;
	@RequestMapping("/")
	public String welcome(Model model)
	{
		// not invoking any services.
		// get some data from Service Layer
		// make some data here.
		// share that data to the thymleaf/html
		
		model.addAttribute("message1", "hello, iam from controller");
		return "index";
	}
	@RequestMapping("/list_employees")
	public String listEmployees(Model model)
	{
		List<Employee> listEmp=empService.getList();
		model.addAttribute("employees",listEmp);
		
		return "employees";
	}
	@RequestMapping("/new")
	public String showEmpForm(Model model)
	{
		Employee e = new Employee();
		model.addAttribute(e);
		return "new_employee";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveEmp(@ModelAttribute("employee") Employee emp)
	{
		empService.save(emp);
		return "redirect:/list_employees";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable(name="id") int id)
	{
		ModelAndView mav = new ModelAndView("edit_employee");
		Employee e = empService.get(id);
		mav.addObject("employee",e);
		return mav;
	}
	

}
