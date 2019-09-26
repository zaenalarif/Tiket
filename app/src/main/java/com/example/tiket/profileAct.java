package com.example.tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class profileAct extends AppCompatActivity {

    LinearLayout item_my_ticket;
    Button btn_edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        item_my_ticket  = findViewById(R.id.item_my_ticket);
        btn_edit_profile= findViewById(R.id.btn_edit_profile);

        item_my_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotomyticket = new Intent(profileAct.this, myTicketDetailAct.class);
                startActivity(gotomyticket);
            }
        });

        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoEditProfile = new Intent(profileAct.this, editProfileAct.class);
                startActivity(gotoEditProfile);
            }
        });
    }
}
