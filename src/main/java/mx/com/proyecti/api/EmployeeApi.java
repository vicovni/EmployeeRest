package mx.com.proyecti.api;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.com.proyecti.service.Employee;
import mx.com.proyecti.service.EmployeeServiceProxy;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@EnableAutoConfiguration
public class EmployeeApi {
	
	EmployeeServiceProxy proxy = new EmployeeServiceProxy();
	
	@RequestMapping("/")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/getAllEmployees")
	public Employee[] getAllEmployees() {
		try {
			return proxy.getAllEmployees();
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/createEmployee")
	public Employee createEmployee(@RequestParam String firstName, 
			@RequestParam String lastName, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date birthdate, 
			@RequestParam double salary) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(birthdate);
			return proxy.setEmployee(firstName, lastName, calendar, salary);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/getEmployee")
	public Employee getEmployee(@RequestParam(value="id") int idEmployee) {
		try {
			return proxy.getEmployee(idEmployee);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/deleteEmployee")
	public boolean deleteEmployee(@RequestParam(value="id")int idEmployee) {
		try {
			return proxy.deleteEmployee(idEmployee);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("/updateEmployee")
	public Employee updateEmployee(
			@RequestParam(value="id")int idEmployee, 
			@RequestParam(value="firstName")String firstName, 
			@RequestParam(value="lastName")String lastName, 
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			@RequestParam(value="birthdate")Calendar date, 
			@RequestParam(value="salary")double salary) {
		try {
			return proxy.updateEmployee(idEmployee, firstName, lastName, date, salary);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApi.class, args);

	}

}
