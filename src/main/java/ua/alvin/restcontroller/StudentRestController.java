package ua.alvin.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.alvin.entity.Student;
import ua.alvin.entity.StudentErrorResponseEntity;
import ua.alvin.exception.StudentNotFoundException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> studentList;

    @PostConstruct
    private void loadDataToList() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Mary", "Queen"));
        studentList.add(new Student("Bob", "Knight"));
        studentList.add(new Student("Liza", "Peasant"));
    }

    @GetMapping("/students")
    public List<Student> getStudentsList() {

//        loadDataToList();

        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

//        loadDataToList();

        if (studentId >= studentList.size() || studentId < 0)
            throw new StudentNotFoundException("Student with id #" + studentId + " not found");

        return studentList.get(studentId);
    }

}
