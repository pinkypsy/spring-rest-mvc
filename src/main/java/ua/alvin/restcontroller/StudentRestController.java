package ua.alvin.restcontroller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
import ua.alvin.entity.Student;
import ua.alvin.exception.OutOfBoundsExceptionToJson;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.alvin.entity.Student;
import ua.alvin.entity.StudentErrorResponseEntity;
import ua.alvin.exception.StudentNotFoundException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
>>>>>>> win
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
<<<<<<< HEAD
    public List<Student> getStudentsList(){
=======
    public List<Student> getStudentsList() {
>>>>>>> win

//        loadDataToList();

        return studentList;
    }

<<<<<<< HEAD
        @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) throws OutOfBoundsExceptionToJson {

//        loadDataToList();

            try {
                return studentList.get(studentId);
            } catch (Exception e) {
                OutOfBoundsExceptionToJson outOfBoundsExceptionToJson = new OutOfBoundsExceptionToJson();
                outOfBoundsExceptionToJson.setStatus("9999");
                throw outOfBoundsExceptionToJson;
            }
        }

    @ExceptionHandler
    public Throwable handleExc(Throwable throwable){
        System.out.println("IN HANDLER");
        OutOfBoundsExceptionToJson outOfBoundsExceptionToJson = (OutOfBoundsExceptionToJson) throwable;

        System.out.println(throwable);

        return throwable;
    }
=======
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

//        loadDataToList();

        if (studentId >= studentList.size() || studentId < 0)
            throw new StudentNotFoundException("Student with id #" + studentId + " not found");

        return studentList.get(studentId);
    }

>>>>>>> win
}
