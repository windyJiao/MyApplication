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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.show);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private static final String TAG = "MainActivity";
    private TextView tv;

    // 点击事件处理方法
    public void myclick(View v) {
        Log.i(TAG, "onClick:555");
        EditText input1 = findViewById(R.id.inp);
        EditText input2 = findViewById(R.id.weight);
        String sh = input1.getText().toString();
        String sw = input2.getText().toString();

        try {
            float height = Float.parseFloat(sh);
            float weight = Float.parseFloat(sw);
            float bmi = weight / (height * height);
            String bmi1= String.format("%.2f", bmi);
            tv.setText("BMI:" + bmi1);
        } catch (NumberFormatException e) {
            Log.e(TAG, "输入的不是有效的数字");
            tv.setText("输入错误，请输入数字");
        }
    }
}