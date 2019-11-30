package mockito.dependency;

import java.util.List;

public class EmployeeService {

	private EmployeeDao	employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<String> getEmployeeNames() {
		System.out.println("inside getEmployeeNames() method");
		return employeeDao.getEmployeeNames();
	}
}
