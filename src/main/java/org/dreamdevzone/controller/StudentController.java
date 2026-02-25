package org.dreamdevzone.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.model.dto.StudentDto;
import org.dreamdevzone.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    public void addStudent(@RequestBody StudentDto student) {
        studentService.add(student);
    }
}
