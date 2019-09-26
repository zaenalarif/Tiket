package com.example.tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class successBuyTicketAct extends AppCompatActivity {

    Animation app_splash, btt, ttb;
    ImageView logo_success;
    TextView app_title, app_subtitle;
    Button btn_view_ticket, btn_mydashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);

        logo_success    = findViewById(R.id.logo_success);
        app_title       = findViewById(R.id.app_title);
        app_subtitle    = findViewById(R.id.app_subtitle);
        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        btn_mydashboard = findViewById(R.id.btn_mydashboard);

        // ================= LOAD ANIMATION ===========
        app_splash  = AnimationUtils.loadAnimation(this,R.anim.app_splash);
        btt         = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb         = AnimationUtils.loadAnimation(this, R.anim.btt);

        // ============ animation ========================
        logo_success.startAnimation(app_splash);

        app_title.startAnimation(ttb);
        app_subtitle.startAnimation(ttb);

        btn_view_ticket.startAnimation(btt);
        btn_mydashboard.startAnimation(btt);

    }
}
