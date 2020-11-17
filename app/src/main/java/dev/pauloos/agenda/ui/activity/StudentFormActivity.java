package dev.pauloos.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import dev.pauloos.agenda.DAO.StudentDAO;
import dev.pauloos.agenda.R;
import dev.pauloos.agenda.model.Student;

public class StudentFormActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "New Student";
    private EditText studentName;
    private EditText studentPhone;
    private EditText studentEmail;
    final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);
        setTitle(APPBAR_TITLE);
        initFields();
        setSaveStudentButton();
    }

    private void setSaveStudentButton() {
        Button saveStudentButton = findViewById(R.id.activity_student_form_save_button);
        saveStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student studentCreated = createStudent();
                saveStudent(studentCreated);
            }
        });
    }

    private void initFields() {
        studentName = findViewById(R.id.activity_student_form_name);
        studentPhone = findViewById(R.id.activity_student_form_phone_number);
        studentEmail = findViewById(R.id.activity_student_form_email);
    }

    private void saveStudent(Student student) {
        dao.save(student);
        finish();
    }

    private Student createStudent() {
        String name = studentName.getText().toString();
        String phone = studentPhone.getText().toString();
        String email = studentEmail.getText().toString();
        return new Student(name, phone, email);
    }
}