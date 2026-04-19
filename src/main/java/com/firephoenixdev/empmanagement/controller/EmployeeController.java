package com.firephoenixdev.empmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firephoenixdev.empmanagement.entity.Employee;
import com.firephoenixdev.empmanagement.service.EmployeeService;


@RestController
@RequestMapping("/empmanagement")
@CrossOrigin
public class EmployeeController {
	

	private EmployeeService empservice;
	
	public EmployeeController(EmployeeService empservice)
	{
		this.empservice=empservice;
	}
	
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmp(@RequestBody Employee e)
	{
		Employee savedemp=empservice.addEmp(e);
		return ResponseEntity.ok(savedemp);
		
	}
	
	@GetMapping("/getAll")
    public List<Employee>  getAllEmp()
    {
		return empservice.getAllEmp();
    	
    }
	
	@GetMapping("/getEmp/{id}")
	public ResponseEntity<Optional<Employee>> getEmpByid(@PathVariable int id)
	{
		Optional<Employee> Empbyid =empservice.getEmpByid(id);
		return ResponseEntity.ok(Empbyid);
	}
	
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable int id,@RequestBody Employee e)
	{
		e.setId(id);
	   Employee updatedEmp= empservice.updateEmp(e);
		
		return ResponseEntity.ok(updatedEmp);
		
	}
	
	@GetMapping("/getByDept/{dept}")
	public ResponseEntity<List<Employee>> getEmpByDept(@PathVariable String dept) {
	    List<Employee> list = empservice.getEmpByDept(dept);
	    return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmpByid(@PathVariable int id) {
	    boolean deleted = empservice.deleteEmpByid(id);

	    if (deleted) {
	        return ResponseEntity.ok("Employee deleted successfully");
	    } else {
	        return ResponseEntity.status(404).body("Employee not found with id: " + id);
	    }
	}

}
