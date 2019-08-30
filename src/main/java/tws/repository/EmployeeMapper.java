package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
	List<Employee> selectAll();

	void insert(@Param("employee") Employee employee);

	Employee getOne(@Param("id") String id);

	void updateOne(@Param("id") String id, @Param("employee") Employee employee);

	void deleteOne(@Param("id") String id);

	List<Employee> selectPage(Integer page, Integer pageSize);
}
