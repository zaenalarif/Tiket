 package com.example.tiket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

 public class registerOneAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue;
    EditText username, password, email_address;
    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        username        = findViewById(R.id.username);
        email_address   = findViewById(R.id.email_address);
        password        = findViewById(R.id.password);

        btn_back        = findViewById(R.id.btn_back);
        btn_continue    = findViewById(R.id.btn_continue);

        btn_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // berpindah activity
                Intent gotoback = new Intent(registerOneAct.this, getStartedAct.class);
                startActivity(gotoback);


            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                // menyimpan data kepada local storage (handphone)
                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(username_key, username.getText().toString());
                editor.apply();

                // simpan ke database
                reference = FirebaseDatabase.getInstance()
                        .getReference().child("Users").child(username.getText().toString());

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("username").setValue(username.getText().toString());
                        dataSnapshot.getRef().child("password").setValue(password.getText().toString());
                        dataSnapshot.getRef().child("email_address").setValue(email_address.getText().toString());
                        dataSnapshot.getRef().child("user_balance").setValue(800);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                Intent gotoContinue = new Intent(registerOneAct.this, registerTwoAct.class);
                startActivity(gotoContinue);
            }
        });
    }
}
