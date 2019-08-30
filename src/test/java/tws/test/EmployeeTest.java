package tws.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeTest {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@After
	public void teardown() {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
	}
	@Test
	public void shouldFetchList() {
		//given
		jdbcTemplate.execute("insert into employee values('lalala','6','001')");
		//when
		List<Employee>employees = employeeMapper.selectAll();
		//then
		assertEquals(1, employees.size());
	}
}
