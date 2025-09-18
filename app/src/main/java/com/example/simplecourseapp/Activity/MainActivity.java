package com.example.simplecourseapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.splashscreen.SplashScreen;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.simplecourseapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ConstraintLayout btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,
                        CourseListActivity.class));
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.bottom_item1) {
                    Toast.makeText(MainActivity.this, "Bottom Item 1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.bottom_item2) {
                    Toast.makeText(MainActivity.this, "Bottom Item 2 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.bottom_item3) {
                    Toast.makeText(MainActivity.this, "Bottom Item 3 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.bottom_item4) {
                    Toast.makeText(MainActivity.this, "Bottom Item 4 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.new_course) {
            Toast.makeText(this, "Create a new course", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.edit_course) {
            Toast.makeText(this, "Edit a course", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.setting) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}