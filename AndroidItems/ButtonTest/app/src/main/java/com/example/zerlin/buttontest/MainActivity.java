package com.example.zerlin.buttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一种方式（成员内部类）
        Button button1 = findViewById(R.id.buttonPanel01);
        //多个button同用一个监听器
        Button button5 = findViewById(R.id.buttonPanel05);
        Button button6 = findViewById(R.id.buttonPanel06);
        Button button7 = findViewById(R.id.buttonPanel07);
        class MyButtonListener implements View.OnClickListener{
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.buttonPanel01:
                        Toast.makeText(MainActivity.this,"第一种监听器",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.buttonPanel05:
                        Toast.makeText(MainActivity.this,"究極監聽器5",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.buttonPanel06:
                        Toast.makeText(MainActivity.this,"究極監聽器6",Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.buttonPanel07:
                        Toast.makeText(MainActivity.this,"究極監聽器7",Toast.LENGTH_SHORT)
                                .show();
                        break;
                }
            }
        }
        MyButtonListener mbl = new MyButtonListener();
        button1.setOnClickListener(mbl);
        button5.setOnClickListener(mbl);
        button6.setOnClickListener(mbl);
        button7.setOnClickListener(mbl);

        //第二种方式（匿名内部类）
        Button button2 = findViewById(R.id.buttonPanel02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"第二种监听器",Toast.LENGTH_SHORT).show();
            }
        });

        //第三种方式（activity实现OnClickListener接口）
        Button button3 = findViewById(R.id.buttonPanel03);
        button3.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
            Toast.makeText(MainActivity.this,"第三种监听器",Toast.LENGTH_SHORT).show();
        }


        //第四种方式（xml布局文件中的onClick属性）
    public void myButtonClick(View view){
        Toast.makeText(MainActivity.this,"第四种监听器",Toast.LENGTH_SHORT).show();
    }
}
