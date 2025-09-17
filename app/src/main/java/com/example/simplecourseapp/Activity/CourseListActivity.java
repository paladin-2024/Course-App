package com.example.simplecourseapp.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplecourseapp.Adapter.CoursesAdapter;
import com.example.simplecourseapp.Domain.CoursesDomain;
import com.example.simplecourseapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CourseListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterCourseList;
    private RecyclerView recyclerViewCourse;
    private FloatingActionButton add_button,camera_button,edit_button;
    Animation fabClose, fabOpen, fabRClockwise, fabRAnticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_list);
        initRecyclerView();
        ImageView backbtn = findViewById(R.id.backBtn);
        backbtn.setOnClickListener(v -> finish());

        add_button = findViewById(R.id.add_button);
        camera_button = findViewById(R.id.camera_button);
        edit_button = findViewById(R.id.edit_button);

        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close_fab);
        fabRClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRAnticlockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isOpen){
                    camera_button.startAnimation(fabClose);
                    edit_button.startAnimation(fabClose);
                    add_button.startAnimation(fabRClockwise);
                    camera_button.setClickable(false);
                    edit_button.setClickable(false);
                    isOpen=false;
                }else{
                    camera_button.startAnimation(fabOpen);
                    edit_button.startAnimation(fabOpen);
                    add_button.startAnimation(fabRAnticlockwise);
                    camera_button.setClickable(true);
                    edit_button.setClickable(true);
                    isOpen=true;
                }
            }
        });
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Handle edit button click
                Toast.makeText(CourseListActivity.this, "Edit clicked", Toast.LENGTH_SHORT).show();
                Log.d("FAB", "Edit button clicked");
            }
        });

        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Handle camera button click
                Toast.makeText(CourseListActivity.this, "Camera clicked", Toast.LENGTH_SHORT).show();
                Log.d("FAB", "Camera button clicked");
            }
        });

    }

    private void initRecyclerView() {
        ArrayList<CoursesDomain> items = new ArrayList<>();
        items.add(new CoursesDomain("Advanced Certification Program in AI",169,"ic_1"));
        items.add(new CoursesDomain("Google Cloud Platform Architecture",69,"ic_2"));
        items.add(new CoursesDomain("Fundamental of Java Programming",150,"ic_3"));
        items.add(new CoursesDomain("Introduction to UI design history",79,"ic_4"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering",49,"ic_5"));

        recyclerViewCourse = findViewById(R.id.view);
        recyclerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        adapterCourseList = new CoursesAdapter(items);
        recyclerViewCourse.setAdapter(adapterCourseList);

    }
}