package dev.pauloos.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import dev.pauloos.agenda.model.Student;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }


    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
