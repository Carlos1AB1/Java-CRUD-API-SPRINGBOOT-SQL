package com.example.CRUD.controller;

import com.example.CRUD.entity.Student;
import com.example.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Obtener todos los estudiantes
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    // Obtener un estudiante por ID
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable("studentId") Long studentId) {
        Optional<Student> student = studentService.getStudent(studentId);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el estudiante no existe
        }
    }

    // Crear un nuevo estudiante o actualizar uno existente
    @PostMapping
    public ResponseEntity<Student> saveOrUpdate(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent); // Retorna el estudiante creado/actualizado
    }

    // Actualizar un estudiante existente
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
        Optional<Student> existingStudent = studentService.getStudent(studentId);
        if (existingStudent.isPresent()) {
            student.setStudentId(studentId); // Mantén el ID del estudiante al actualizar
            Student updatedStudent = studentService.saveStudent(student);
            return ResponseEntity.ok(updatedStudent); // Retorna el estudiante actualizado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el estudiante no se encuentra
        }
    }

    // Eliminar un estudiante
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable("studentId") Long studentId) {
        Optional<Student> existingStudent = studentService.getStudent(studentId);
        if (existingStudent.isPresent()) {
            studentService.deleteStudent(studentId);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 si el estudiante no se encuentra
        }
    }
}
