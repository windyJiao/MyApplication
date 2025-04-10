package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class huilvActivity2 extends AppCompatActivity {
    private static final String TAG="huilvActivity";
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_huilv2);
        tv = findViewById(R.id.show);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onclick(View v){
        Log.i(TAG,"onClick:555");
        EditText hello=findViewById(R.id.money);
        float money = 0;
        if(v.getId()==R.id.button2){
            float mon=Float.parseFloat(hello.getText().toString());
            money = mon * 2;
        }
        if(v.getId()==R.id.button3){
            float mon=Float.parseFloat(hello.getText().toString());
            money = mon * 3;
        }
        if(v.getId()==R.id.button4){
            float mon=Float.parseFloat(hello.getText().toString());
            money = mon * 4;
        }
        String mon1=String.format("%.2f",money);
        tv.setText(mon1);
    }
}