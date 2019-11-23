/**
 * 
 */
package com.employee.com.employee.model;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author vinoth
 *
 */

@Entity
@Table(name="employees")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 2348002536427083977L;
	
	@Id
	@Column(name="empId")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long empId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="DOB")
	@JsonDeserialize(using = DateHandler.class)
	private Date DOB;
	@Column(name="dept")
	private String department;	
	
	public Employee() {
		}
	
	public Employee(long empId, String firstName, String lastName, String gender, Date dOB, String department) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		DOB = dOB;
		this.department = department;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", DOB=" + DOB + ", department=" + department + "]";
	}
	
}
	
	class DateHandler extends StdDeserializer<Date> {
		private static final long serialVersionUID = 8879282272780488868L;
		
		public DateHandler() { 
			this(null); 
			}
		
		public DateHandler(Class<?> clazz) { 
			super(clazz); 
			}
		
		@Override 
		public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException { 
			String date = jsonparser.getText(); 
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				return sdf.parse(date);
				} 
			catch (Exception e) {
				return null;
				}
			}
	}

	


