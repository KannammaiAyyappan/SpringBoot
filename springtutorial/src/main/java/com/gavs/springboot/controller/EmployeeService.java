package com.gavs.springboot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gavs.springboot.model.Employee;
import com.gavs.springboot.model.EmployeeDao;
@RestController
public class EmployeeService {
	@RequestMapping("/hello")
    public String welcomepage() {
        return "hello to Spring REST Controller";
    }
    @RequestMapping(value="/findEmployee",method= RequestMethod.POST)
    public Employee homepage(@RequestBody Employee e) {
    	EmployeeDao kite = new EmployeeDao();
    	return kite.findEmployee(e);
        
    }
    @RequestMapping(value="/addEmployee",method= RequestMethod.POST)
     public int addEmployee(@RequestBody Employee emp) {
    	EmployeeDao ls = new EmployeeDao();
    	int res=ls.addEmp(emp);
        return res;
    }
        
    
    @RequestMapping(value="/updateEmployee",method= RequestMethod.PUT)
    public int modifyEmployee(@RequestBody Employee emp) {
    	EmployeeDao emp1 = new EmployeeDao();
        return emp1.modifyEmployee(emp);
    }
    @RequestMapping(value="/removeEmployee",method= RequestMethod.DELETE)
    public int removeEmployee(@RequestBody	Employee emp) {
    	EmployeeDao emp2 = new EmployeeDao();
    	return emp2.deleteEmployee(emp);
        

    }
    
}
