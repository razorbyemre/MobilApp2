package com.example.schedule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class GroupSettingsActivity extends AppCompatActivity {

    Button back;
    Button addGroup;
    FirebaseDatabase database;
    DatabaseReference ref, ref2;
    EditText txtGroup;
    String Child, key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_settings);

        Define();
        Action();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToAdmin();
            }
        });

    }

    public void Action() {

        addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference ref2 = ref.child("Groups").push();
                key = ref2.getKey();
                Map mp = setMessage(txtGroup.getText().toString());
                Map mp2 = new HashMap();
                mp2.put(Child + key, mp);
                ref.updateChildren(mp2, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                        txtGroup.setText("");
                        Toast.makeText(getApplicationContext(), "Record Successful", Toast.LENGTH_LONG).show();
                    }
                });


               /* String edit = txtGroup.getText().toString();
                txtGroup.setText("");
                ref = database.getReference("Groups");
                ref2 = ref.child("Group");
                ref2.setValue(edit);*/


            }
        });
    }

    public Map setMessage(String group) {

        Map map = new HashMap();
        map.put("Groups", group);

        return map;

    }

    public void Define() {
        back = (Button) findViewById(R.id.btnGroupBack);
        addGroup = (Button) findViewById(R.id.btnAddGroup);
        txtGroup = (EditText) findViewById(R.id.editTextGroup);
        database = FirebaseDatabase.getInstance();
        Child = "Group/";

    }


    private void backToAdmin() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
    }




}

