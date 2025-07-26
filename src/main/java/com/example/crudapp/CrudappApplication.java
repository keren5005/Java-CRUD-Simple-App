package com.example.crudapp;

import DAO.EmployeeDAOInterface;
import entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner clr(EmployeeDAOInterface employeeDAOInterface)
	{
		return runner ->
		{
			readEmployee(employeeDAOInterface);
			employeeQuery(employeeDAOInterface);
			updatedEmployee(employeeDAOInterface);
			deleteEmployee(employeeDAOInterface);
			deleteAllEmployees(employeeDAOInterface);
			createEmployee(employeeDAOInterface);
		};
	}

	private void createEmployee(EmployeeDAOInterface employeeDAOInterface) {

		// create the employee object
		System.out.println("Creating employee objects...");

		Employee newEmployee1 = new Employee("Casie", "Smith", "casiesmith@example.com");
		Employee newEmployee2 = new Employee("Mary", "Brown", "marybrown@example.com");
		Employee newEmployee3 = new Employee("Nicole", "Collins", "nicolecollins@example.com");
		Employee newEmployee4 = new Employee("William", "Holmes", "williamholmes@example.com");

		// save the employee object
		System.out.println("Saving employee objects...");
		employeeDAOInterface.save(newEmployee1);
		employeeDAOInterface.save(newEmployee2);
		employeeDAOInterface.save(newEmployee3);
		employeeDAOInterface.save(newEmployee4);

		// Show the id of the new employee
		System.out.println("New employee id: " + newEmployee1.getId());
	}

	private void deleteAllEmployees(EmployeeDAOInterface employeeDAOInterface) {
		System.out.println("Delete all employees");
		int rowsDeleted = employeeDAOInterface.deleteAll();
		System.out.println("Number of roes deleted:" + rowsDeleted);

	}

	private void deleteEmployee(EmployeeDAOInterface employeeDAOInterface) {
		int id = 2;
		System.out.println("Deleting emploiyee id:" + id);
		employeeDAOInterface.delete(id);
	}

	private void updatedEmployee(EmployeeDAOInterface employeeDAOInterface) {

		int id = 1;
		System.out.println("Retriving  employee by id: " + id);
		Employee employee = employeeDAOInterface.findById(id);

		System.out.println("Updating employee...");
		employee.setFirstName("Maya");
		employeeDAOInterface.update(employee);

		System.out.println("Updatd employee: "+ employee);

	}

	private void employeeQuery(EmployeeDAOInterface employeeDAOInterface) {

		List <Employee> employee = employeeDAOInterface.findAll();

		for(Employee newEmployee : employee) {
			System.out.println(newEmployee);
		}
	}


	private void readEmployee(EmployeeDAOInterface employeeDAOInterface) {

		System.out.println("Creating the employee...");
		Employee newEmployee = new Employee("Csie", "Smith", "casie@email.com");

		System.out.println("Saving the employee...");
		employeeDAOInterface.save(newEmployee);

		System.out.println("New employee id: " + newEmployee.getId());
		System.out.println("Reading employee with id: " + newEmployee.getId());
		Employee employee = employeeDAOInterface.findById(newEmployee.getId());
		System.out.println("Employee found :" + employee);


	}

}


