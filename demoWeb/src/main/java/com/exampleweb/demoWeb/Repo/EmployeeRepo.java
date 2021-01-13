package com.exampleweb.demoWeb.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.exampleweb.demoWeb.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
