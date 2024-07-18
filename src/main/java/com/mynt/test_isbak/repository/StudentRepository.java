package com.mynt.test_isbak.repository;

import com.mynt.test_isbak.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findById (int i);
//   List<Student> findAllOrderByAge();
//List<Student> findByNameIn(List<String> names);


}
