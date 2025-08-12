package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Student;
import com.spring.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	 private StudentRepository repo;
		
		public void saveStudent(Student student) {
			repo.save(student);
		}
		
		public List<Student> getAllStudents(){
			return repo.findAll();
		}
		
//		public Optional<Student> getById(long id) {
//			//Student student = repo.findById(id).orElse(null);
//			//return student;
//			 return Optional.of(repo.findById(id).orElse(null));
//		}
		
		public Student getById(long id) {
			Student student=repo.findById(id).orElse(null);
			return student;
		}
		
		public boolean updateStudent(Long id,Student updateStudent) {
			Optional<Student> existingStudent = repo.findById(id);
			
			if(existingStudent.isPresent()) {
				Student student = existingStudent.get();
				student.setName(updateStudent.getName());
				student.setEmail(updateStudent.getEmail());
				repo.save(student);
				return true;
			}else {
				return false;
			}
			}
		
		public boolean deleteStudent(long id) {
			if(repo.existsById(id)) {
				repo.deleteById(id);
			}
			return false;
	}
}

