/**
 * EmployeeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.proyecti.service;

public interface EmployeeService extends java.rmi.Remote {
    public mx.com.proyecti.service.Employee[] getAllEmployees() throws java.rmi.RemoteException;
    public mx.com.proyecti.service.Employee setEmployee(java.lang.String firstname, java.lang.String lastname, java.util.Calendar date, double salary) throws java.rmi.RemoteException;
    public mx.com.proyecti.service.Employee getEmployee(int id) throws java.rmi.RemoteException;
    public boolean deleteEmployee(int id) throws java.rmi.RemoteException;
    public mx.com.proyecti.service.Employee updateEmployee(int id, java.lang.String firstname, java.lang.String lastname, java.util.Calendar date, double salary) throws java.rmi.RemoteException;
}
