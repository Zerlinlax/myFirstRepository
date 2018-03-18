package com.example.zerlin.linear_layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.Toast;

public class LinearLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button = findViewById(R.id.buttonPanel);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {//这里要用.this还是内部类的问题
                Toast.makeText(LinearLayout.this,"我也不知道封面",Toast.LENGTH_LONG).show();
            }
        });
    }
}
