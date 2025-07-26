package DAO;

import entity.Employee;

import java.util.List;

public interface EmployeeDAOInterface {

    void save(Employee employee);

    Employee findById(Integer id);

    List<Employee> findAll();

    List<Employee> findByLastName(String lastName);

    void update(Employee employee);

    void delete(Integer id);

    int deleteAll();
}
