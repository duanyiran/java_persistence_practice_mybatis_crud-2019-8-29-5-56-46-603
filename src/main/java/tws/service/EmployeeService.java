package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeDto getEmployeeDto(String id) {
		Employee employee = employeeMapper.getOne(id);
		String desc = "name:" + employee.getName() + ",age:" + employee.getAge();
		EmployeeDto employeeDto = new EmployeeDto(employee.getAge(), employee.getId(), employee.getName(), desc);
		return employeeDto;
	}

	public List<Employee> selectPage(int page, int pageSize) {
		return employeeMapper.selectPage(page, pageSize);
	}

	public List<Employee> selectAll() {

		return employeeMapper.selectAll();
	}

	public void insert(Employee employee) {
		employeeMapper.insert(employee);
	}

	public Employee getOne(String id) {
		return employeeMapper.getOne(id);
	}

	public void deleteOne(String id) {
		employeeMapper.deleteOne(id);
	}

	public void updateOne(String id, Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateOne(id, employee);
	}
}
