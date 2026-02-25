package org.dreamdevzone.controller;

import lombok.RequiredArgsConstructor;
import org.dreamdevzone.model.dto.StudentDto;
import org.dreamdevzone.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Integer id) {
        return studentService.get(id);
    }
    @GetMapping("/getAll")
    public List<StudentDto> getAll(Pageable pageable) {
        return studentService.getAll(pageable);
    }
    @DeleteMapping
    public void deleteStudent(@RequestParam Integer id) {
        studentService.delete(id);
    }
    @PostMapping("/{id}")
    public StudentDto update(@PathVariable Integer id, @RequestBody StudentDto student) {
        return studentService.update(student, id);
    }
}
