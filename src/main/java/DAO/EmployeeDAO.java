package DAO;

import DAO.EmployeeDAOInterface;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

public class EmployeeDAO implements EmployeeDAOInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery(
                "FROM Employee ORDER BY lastName asc", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee Where LASTnAME=:DATA", Employee.class);
        query.setParameter("data", lastName);

        return query.getResultList();

    }

    @Override
    @Transactional
    public void update(Employee employee) {
        entityManager.merge(employee);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleted = entityManager.createQuery("DELETE FROM Employee").executeUpdate();;
        return rowsDeleted;
    }


}
