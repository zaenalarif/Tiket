package com.example.tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import javax.crypto.spec.IvParameterSpec;

public class successRegisterAct extends AppCompatActivity {

    Button btn_explore;

    Animation app_splash, btt, ttb;
    ImageView icon_success;
    TextView app_title, app_subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        btn_explore = findViewById(R.id.btn_explore);

        // ========= ANIMATION =================
        app_splash  = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt         = AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb         = AnimationUtils.loadAnimation(this, R.anim.ttb);

        icon_success    = findViewById(R.id.icon_success);
        app_title       = findViewById(R.id.app_title);
        app_subtitle   = findViewById(R.id.app_subtitle);

        icon_success.startAnimation(app_splash);
        app_title.startAnimation(ttb);
        app_subtitle.startAnimation(app_splash);
        btn_explore.startAnimation(btt);


        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoHome = new Intent(successRegisterAct.this, homeAct.class);
                startActivity(gotoHome);
            }
        });
    }
}
