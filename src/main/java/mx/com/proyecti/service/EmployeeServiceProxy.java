package mx.com.proyecti.service;

public class EmployeeServiceProxy implements mx.com.proyecti.service.EmployeeService {
  private String _endpoint = null;
  private mx.com.proyecti.service.EmployeeService employeeService = null;
  
  public EmployeeServiceProxy() {
    _initEmployeeServiceProxy();
  }
  
  public EmployeeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceProxy();
  }
  
  private void _initEmployeeServiceProxy() {
    try {
      employeeService = (new mx.com.proyecti.service.EmployeeServiceServiceLocator()).getEmployeeServicePort();
      if (employeeService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeService != null)
      ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.proyecti.service.EmployeeService getEmployeeService() {
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService;
  }
  
  public mx.com.proyecti.service.Employee[] getAllEmployees() throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.getAllEmployees();
  }
  
  public mx.com.proyecti.service.Employee setEmployee(java.lang.String firstname, java.lang.String lastname, java.util.Calendar date, double salary) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.setEmployee(firstname, lastname, date, salary);
  }
  
  public mx.com.proyecti.service.Employee getEmployee(int id) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.getEmployee(id);
  }
  
  public boolean deleteEmployee(int id) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.deleteEmployee(id);
  }
  
  public mx.com.proyecti.service.Employee updateEmployee(int id, java.lang.String firstname, java.lang.String lastname, java.util.Calendar date, double salary) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.updateEmployee(id, firstname, lastname, date, salary);
  }
  
  
}