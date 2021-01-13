package com.exampleweb.demoWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleweb.demoWeb.Entity.Employee;
import com.exampleweb.demoWeb.Repo.*;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo EmployeeRepo;
	public List<Employee> getList(){
		List<Employee> list=EmployeeRepo.findAll();
		return list;
	}
	public void save(Employee e) {
		 EmployeeRepo.save(e);
	}
	public Employee get(int id)
	{
		return EmployeeRepo.findById(id).get();
	}

}
