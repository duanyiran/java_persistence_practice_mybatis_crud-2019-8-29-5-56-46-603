package tws.dto;

import tws.entity.Employee;

public class EmployeeDto {
	
	private String name;
	private String age;
	private String id;
	private String desc;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public EmployeeDto() {
		
	}
	public EmployeeDto(String name, String age, String id, String desc) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.desc = desc;
	}

	
}
