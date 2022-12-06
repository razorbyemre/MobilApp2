package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    Button logout;
    Button scheduleSettings;
    Button groupSettings;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        logout = findViewById(R.id.btnLogout);
        scheduleSettings= findViewById(R.id.btnSettingsSchedule);
        groupSettings = findViewById(R.id.btnSettingsGroup);


        logout.setOnClickListener(view -> backToMain());//seton clicking kisa kullanimi.


        scheduleSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSchedule();
            }
        });

        groupSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGroup();
            }
        });

    }

    private  void backToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private  void goToSchedule(){
        Intent intent = new Intent(this,ScheduleSettingsActivity.class);
        startActivity(intent);
    }

    private  void goToGroup(){
        Intent intent = new Intent(this,GroupSettingsActivity.class);
        startActivity(intent);
    }
}