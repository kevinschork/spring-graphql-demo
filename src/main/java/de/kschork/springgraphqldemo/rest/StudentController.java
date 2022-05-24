package de.kschork.springgraphqldemo.rest;

import de.kschork.springgraphqldemo.domain.Student;
import de.kschork.springgraphqldemo.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping(produces = "application/json")
    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Student getOne(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    private static class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(Long id) {
            super("Could not find Student " + id);
        }
    }
}
