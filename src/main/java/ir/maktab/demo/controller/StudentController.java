package ir.maktab.demo.controller;

import ir.maktab.demo.domain.Student;
import ir.maktab.demo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * @author Alireza.d.a
 */
//Use Service
@RestController
@RequestMapping("api")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("all-students")
    public List<Student> findAllStudents() {

//        List<Student> students = new LinkedList<>();
//        Student student1 = new Student("Ali","Reza");
//        Student student2 = new Student("Piaz","Kalam");
//        Student student3 = new Student("Xian","Lu");
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);

        return studentRepository.findAll();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id){
        Optional<Student> byId = studentRepository.findById(id);
//        studentRepository.getOne();
        return byId.get();
    }

    @GetMapping("test")
    public List<Student> findByLastName(){

        return studentRepository.findByLastName("Lina");
    }

    @GetMapping("test1")
    public List<Student> findByFirstNameAndLastName(){

        return studentRepository.findByFirstNameAndLastName("Xiao","Lina");
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
