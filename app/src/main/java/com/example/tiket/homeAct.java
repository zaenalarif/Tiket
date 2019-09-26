package com.example.tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.github.florent37.shapeofview.shapes.CircleView;

public class homeAct extends AppCompatActivity {

    LinearLayout btn_ticket_pisa;
    CircleView btn_to_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_ticket_pisa = findViewById(R.id.btn_ticket_pisa);
        btn_to_profile  = findViewById(R.id.btn_to_profile);

        btn_ticket_pisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotopisaticket = new Intent(homeAct.this, ticketDetailAct.class);
                startActivity(gotopisaticket);
            }
        });

        btn_to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoProfile = new Intent(homeAct.this, profileAct.class);
                startActivity(gotoProfile);
            }
        });
    }
}
