package com.example.tiket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ticketCheckoutAct extends AppCompatActivity {

    Button btn_pay_now;
    Button btn_plus, btn_minus;
    TextView textJumlahTicket, textTotalHarga, textMybalance;
    ImageView notice_uang;
    Integer valueJumlahTicket = 1;

    Integer myBalance           = 200;
    Integer valueTotalHarga     = 25;
    Integer valueHargaTicket    = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btn_pay_now = findViewById(R.id.btn_pay_now);

        btn_plus        = findViewById(R.id.btn_plus);
        btn_minus       = findViewById(R.id.btn_minus);
        textJumlahTicket= findViewById(R.id.textJumlahTicket);
        textTotalHarga  = findViewById(R.id.textTotalHarga);
        textMybalance   = findViewById(R.id.textMybalance);
        notice_uang     = findViewById(R.id.icon_notice_uang);

        // Seting Value baru untuk beberapa komponen
        textJumlahTicket.setText(valueJumlahTicket.toString());
        textTotalHarga.setText("US$ "+ valueTotalHarga + "");
        textMybalance.setText("US$ "+ myBalance + "");

        // secara default ,kita hide btn minus
        btn_minus.animate().alpha(0).setDuration(300).start();
        btn_minus.setEnabled(false);

        valueTotalHarga = valueHargaTicket * valueJumlahTicket;
        textTotalHarga.setText("$US "+ valueTotalHarga +"");
        notice_uang.setVisibility(View.GONE);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueJumlahTicket += 1;
                textJumlahTicket.setText(valueJumlahTicket.toString());
                if(valueJumlahTicket > 1){
                    btn_minus.animate().alpha(1).setDuration(300).start();
                    btn_minus.setEnabled(true);
                }
                valueTotalHarga = valueHargaTicket * valueJumlahTicket;
                textTotalHarga.setText("$US "+ valueTotalHarga +"");
                if (valueTotalHarga > myBalance){
                    btn_pay_now.animate().translationY(250).alpha(0).setDuration(350).start();
                    btn_pay_now.setEnabled(false);
                    textMybalance.setTextColor(Color.parseColor("#D1206B"));
                    notice_uang.setVisibility(View.VISIBLE);
                }
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueJumlahTicket -= 1;
                textJumlahTicket.setText(valueJumlahTicket.toString());
                if(valueJumlahTicket < 2){
                    btn_minus.animate().alpha(0).setDuration(300).start();
                    btn_minus.setEnabled(false);
                }
                valueTotalHarga = valueHargaTicket * valueJumlahTicket;
                textTotalHarga.setText("US$ "+ valueTotalHarga +"");
                if (valueTotalHarga <= myBalance){
                    btn_pay_now.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_pay_now.setEnabled(true);
                    textMybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);
                }
            }
        });

        btn_pay_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoSuccessBuyTicket = new Intent(ticketCheckoutAct.this, successBuyTicketAct.class);
                startActivity(gotoSuccessBuyTicket);
            }
        });
    }
}
