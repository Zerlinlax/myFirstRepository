package com.example.zerlin.ui_pickershomework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class OtherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Button buttonPanel = findViewById(R.id.buttonPanel);
        Button button_pick = findViewById(R.id.button_pick);
        MyClickListener myClickListener = new MyClickListener();
        buttonPanel.setOnClickListener(myClickListener);
        button_pick.setOnClickListener(myClickListener);


    }

    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
                Intent intent = new Intent();
                switch (view.getId()) {
                    case R.id.buttonPanel:
                        intent.setClass(OtherActivity.this,MainActivity.class);
                        break;
                    case R.id.button_pick:
                        intent.setClass(OtherActivity.this,PickActivity.class);
                        break;
                }
                startActivity(intent);
        }
    }
}
