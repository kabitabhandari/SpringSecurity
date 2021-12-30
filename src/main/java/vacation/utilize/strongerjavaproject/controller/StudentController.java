package vacation.utilize.strongerjavaproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vacation.utilize.strongerjavaproject.model.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final List<Student> allStudentsList = Arrays.asList(new Student(01, "Kabita" , "Texas"),
                                                                new Student(02, "Hari" , "Houston"),
                                                                new Student(03, "Binita" , "Falls"),
                                                                new Student(04, "Ankit" , "Springs"),
                                                                new Student(05, "Tara" , "Rhode"));




    @GetMapping(path = "{studentIdentity}")
    public Student getStudent (@PathVariable("studentIdentity") Integer studentId){
        return allStudentsList
                .stream()
                .filter(f -> f.getId().equals(studentId))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student with id " + studentId + " does not exist"));
    }
}

