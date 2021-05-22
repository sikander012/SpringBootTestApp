package in.nareshit.raghu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.model.Student;
import in.nareshit.raghu.repository.StudentRepository;
import in.nareshit.raghu.util.StudentUtil;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo; // HAS-A relation

	@Override
	public Integer saveStudent(Student s) {
		StudentUtil.calculateDtls(s);
		s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {

		/*
		 * Optional<Student> opt = repo.findById(id);
		 * 
		 * if (opt.isPresent()) { return opt.get(); } else { return null; }
		 */

		return repo.findById(id);

	}

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

}
