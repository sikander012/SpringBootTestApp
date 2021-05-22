package in.nareshit.raghu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Message;
import in.nareshit.raghu.model.Student;
import in.nareshit.raghu.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService service;

	// 1. save
	@PostMapping("/save")
	public ResponseEntity<Message> saveStudent(@RequestBody Student s) {

		ResponseEntity<Message> resp = null;

		try {
			Integer id = service.saveStudent(s);
			resp = new ResponseEntity<Message>(new Message("SUCCESS", id + " saved "), HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("FAIL", "Unable to save"), HttpStatus.OK);
			e.printStackTrace();
		}

		return resp;
	}

	// 2. update
	@PutMapping("/update")
	public ResponseEntity<Message> updateStudent(@RequestBody Student s) {

		ResponseEntity<Message> resp = null;

		try {
			boolean exist = service.isExist(s.getStdId());

			if (exist) {
				service.saveStudent(s);
				resp = new ResponseEntity<Message>(new Message("SUCCESS" + s.getStdId(), " Updated"), HttpStatus.OK);

			} else {
				resp = new ResponseEntity<Message>(new Message("FAIL", s.getStdId() + " Not Exists"), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("FAIL", "Unable to update"), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;

	}

	// 3. delete
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Message> deleteStudent(@PathVariable Integer id) {

		ResponseEntity<Message> resp = null;

		try {

			boolean exist = service.isExist(id);

			if (exist) {
				service.deleteStudent(id);
				resp = new ResponseEntity<Message>(new Message("SUCCESS", id + " Removed"), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Message>(new Message("FAIL", id + " Not Exist"), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {

			resp = new ResponseEntity<Message>(new Message("FAIL", "Unable to delete"), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	// 4. getOne
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneStudent(@PathVariable Integer id) {

		ResponseEntity<?> resp = null;

		try {

			Optional<Student> opt = service.getOneStudent(id);

			if (opt.isPresent()) {
				resp = new ResponseEntity<Student>(opt.get(), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<String>("No data found", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	// 5.getAll
	/*
	 * @GetMapping("/all") public ResponseEntity<?> getAllStudent() {
	 * 
	 * ResponseEntity<?> resp = null;
	 * 
	 * try {
	 * 
	 * List<Student> list = service.getAllStudent();
	 * 
	 * if (!list.isEmpty() && list != null) { resp = new
	 * ResponseEntity<List<Student>>(list, HttpStatus.OK); } else { resp = new
	 * ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST); }
	 * 
	 * } catch (Exception e) {
	 * 
	 * resp = new ResponseEntity<String>("Unable to Fetch Data ",
	 * HttpStatus.INTERNAL_SERVER_ERROR); e.printStackTrace(); }
	 * 
	 * return resp;
	 * 
	 * }
	 */
}
