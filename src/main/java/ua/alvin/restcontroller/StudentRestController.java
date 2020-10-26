package ua.alvin.restcontroller;

import org.springframework.web.bind.annotation.*;
import ua.alvin.entity.Student;
import ua.alvin.exception.OutOfBoundsExceptionToJson;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Student> getStudentsList(){

//        loadDataToList();

        return studentList;
    }

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
}
