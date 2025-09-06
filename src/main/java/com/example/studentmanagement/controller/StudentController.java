package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = {"https://stdm.netlify.app/",
        "https://managestd.netlify.app",
        "http://localhost:5173"
}) // allow React frontend
public class StudentController {


    private final StudentService service;

    public StudentController(StudentService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }


    @GetMapping("/stack/{stack}")
    public List<Student> getStack(@PathVariable String stack){return service.getStack(stack);}

    @GetMapping("name/{name}")
    public  List<Student> getName(@PathVariable String name){return  service.getName(name);}

    @GetMapping("city/{city}")
    public  List<Student> getCity(@PathVariable String city){return  service.getCity(city);}


}
