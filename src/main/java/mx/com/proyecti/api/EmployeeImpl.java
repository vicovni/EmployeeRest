package mx.com.proyecti.api;

import java.rmi.RemoteException;

import mx.com.proyecti.service.Employee;
import mx.com.proyecti.service.EmployeeServiceProxy;

public class EmployeeImpl {

	

	public static void main(String[] args) {
		EmployeeServiceProxy proxy = new EmployeeServiceProxy();
		try {
			Employee[] emp = proxy.getAllEmployees();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
