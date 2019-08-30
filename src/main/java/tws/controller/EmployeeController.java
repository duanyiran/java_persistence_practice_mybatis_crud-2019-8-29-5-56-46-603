package tws.controller;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tws.dto.EmployeeDto;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("")
	public ResponseEntity<List<Employee>> getAll(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) String keyword) {
		if (page != null && pageSize != null) {
			return ResponseEntity.ok(employeeService.selectPage(page, pageSize));
		}
		return ResponseEntity.ok(employeeService.selectAll());
	}

	@PostMapping("")
	public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
		String id = UUID.randomUUID().toString();
		employee.setId(id);
		employeeService.insert(employee);
		return ResponseEntity.created(URI.create("/employees/" + id)).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getOne(@PathVariable String id) {
		Employee employee = employeeService.getOne(id);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateOne(@PathVariable String id, @RequestBody Employee employee) {
		employeeService.updateOne(id, employee);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable String id) {
		employeeService.deleteOne(id);
	}

	@GetMapping("/desc/{id}")
	public ResponseEntity<EmployeeDto> getDescById(@PathVariable String id) {

		return ResponseEntity.ok(employeeService.getEmployeeDto(id));

	}
}