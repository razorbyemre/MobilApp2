package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScheduleSettingsActivity extends AppCompatActivity {

    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_settings);





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToAdmin();
            }
        });


    }

    private  void backToAdmin(){
        Intent intent = new Intent(this,AdminActivity.class);
        startActivity(intent);
    }
}