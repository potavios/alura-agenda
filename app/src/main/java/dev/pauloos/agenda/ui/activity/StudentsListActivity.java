package dev.pauloos.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import dev.pauloos.agenda.DAO.StudentDAO;
import dev.pauloos.agenda.R;

public class StudentsListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Students List";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        setTitle(APPBAR_TITLE);
        setFABNewStudent();
    }

    private void setFABNewStudent() {
        FloatingActionButton addNewStudentButton = findViewById(R.id.activity_students_list_fab_new_student);
        addNewStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentFormActivity();
            }
        });
    }

    private void openStudentFormActivity() {
        startActivity(new Intent(this, StudentFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setStudentsList();

    }

    private void setStudentsList() {
        ListView studentsList = findViewById(R.id.activity_students_list_listview);
        studentsList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getAllStudents()));
    }
}
