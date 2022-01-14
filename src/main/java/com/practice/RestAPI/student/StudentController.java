package com.practice.RestAPI.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService service;
    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping(path = "/all")
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @PostMapping(path = "/add")
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
    }

    @DeleteMapping(path = "/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        service.deleteStudent(studentId);
    }

    @PutMapping(path = "/update/{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        service.updateStudent(studentId, name, email);
    }
}
