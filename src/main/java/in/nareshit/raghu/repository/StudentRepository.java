package in.nareshit.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	//dynamic proxy class will generate+onject
}
