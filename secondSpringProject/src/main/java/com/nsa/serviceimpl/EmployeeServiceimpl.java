package com.nsa.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsa.entity.Employee;
import com.nsa.exceptionClasses.EmployeenotFoundException;
import com.nsa.repository.EmployeeRepo;
import com.nsa.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> findlistEmp(int id1, int id2, int id3) {

		Employee emp = repo.findById(id1).orElseThrow(() -> new EmployeenotFoundException("employye not found"));
		Optional<Employee> getId2 = repo.findById(id2);
		Optional<Employee> getId3 = repo.findById(id3);

		if (emp != null & getId2.isPresent() & getId3.isPresent()) {

			// List<Employee> allById = repo.findAllById(Arrays.asList(id1, id2, id3));
			// return allById;

			Employee emp2 = getId2.get();
			Employee emp3 = getId3.get();
			List<Employee> asList = Arrays.asList(emp, emp2, emp3);
			return asList;
		} else {
			return null;
		}

	}

	@Override
	public String deleteListEmp(int id1, int id2, int id3) {

		// repo.delete(repo.findById(id1).orElseThrow(() -> new
		// EmployeenotFoundException(
		// String.format("Employee %s having %d id not found", Employee.class.getName(),
		// id1))));
		// return "Employees Deleted";

		Optional<Employee> getId1 = repo.findById(id1);
		Optional<Employee> getId2 = repo.findById(id2);
		Optional<Employee> getId3 = repo.findById(id3);

		if (getId1.isPresent() & getId2.isPresent() & getId3.isPresent()) {
			repo.deleteAllInBatch(Arrays.asList(getId1.get(), getId2.get(), getId3.get()));
			return "Employees Deleted";
		} else {
			return "Employees not Deleted";
		}

		// repo.deleteAllById(Arrays.asList(id1, id2, id3));
		// return "Employees Deleted";

	}

}
