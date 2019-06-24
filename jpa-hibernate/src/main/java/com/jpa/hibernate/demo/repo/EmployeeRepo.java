package com.jpa.hibernate.demo.repo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jpa.hibernate.demo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepo {
	@Autowired
	EntityManager em;
	
public void insert(Employee employee) {
	em.persist(employee);
	}
public List<Employee> fetchAllEmployee() {
	return em.createQuery("select e from Emloyee e",Employee.class).getResultList();
}

	

}
