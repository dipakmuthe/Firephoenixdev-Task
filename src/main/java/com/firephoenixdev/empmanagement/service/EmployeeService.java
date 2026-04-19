package com.firephoenixdev.empmanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.firephoenixdev.empmanagement.entity.Employee;
import com.firephoenixdev.empmanagement.repository.EmployeeRepository;
import java.util.List;
@Service
public class EmployeeService {
	
	private EmployeeRepository emprepo;
	
	public EmployeeService(EmployeeRepository emprepo)
	{
		this.emprepo=emprepo;
	}

	public Employee addEmp(Employee e) {
		
		return emprepo.save(e);
	}

	public Optional<Employee> getEmpByid(int id) {
		
		return emprepo.findById(id);
	}


	public List<Employee> getAllEmp() {
		return emprepo.findAll();
	}

	public Employee updateEmp(Employee e) {
		
		return emprepo.save(e);
	}
	
	public List<Employee> getEmpByDept(String dept) {
		return emprepo.findByDept(dept);
	}
	

	public boolean deleteEmpByid(int id) {
	    if (emprepo.existsById(id)) {
	        emprepo.deleteById(id);
	        return true;
	    }
	    return false;
	}

	
	
	

}
