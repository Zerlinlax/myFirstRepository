package com.example.zerlin.ui_checkbox;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb_1;
    private CheckBox cb_2;
    private CheckBox cb_3;
    private Button button1,button2,button3;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setCheckedChangeListener();
        setClickListener();
    }

    private void initView() {
        cb_1 = findViewById(R.id.cb01);
        cb_2 = findViewById(R.id.cb02);
        cb_3 = findViewById(R.id.cb03);
        button1 = findViewById(R.id.True);
        button2 = findViewById(R.id.False);
        button3 = findViewById(R.id.Get);
        textView = findViewById(R.id.Out);

    }

    private void setCheckedChangeListener() {
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        cb_1.setOnCheckedChangeListener(checkBoxListener);
        cb_2.setOnCheckedChangeListener(checkBoxListener);
        cb_3.setOnCheckedChangeListener(checkBoxListener);

    }

    private void setClickListener(){
        MyButtonListener myButtonListener = new MyButtonListener();
        button1.setOnClickListener(myButtonListener);
        button2.setOnClickListener(myButtonListener);
        button3.setOnClickListener(myButtonListener);

    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //当选中状态发生变化时触发
                CheckBox checkBox = (CheckBox)compoundButton;
                StringBuilder stringBuilder = new StringBuilder("");
                if(b){
                    stringBuilder.replace(0,stringBuilder.length(),"選中");
                }else{
                    stringBuilder.replace(0,stringBuilder.length(),"不選");
                }
                switch(checkBox.getId()){
                    case R.id.cb01:
                        if(stringBuilder.toString().equals("選中")) {
                            cb_1.setTextColor(Color.GREEN);
                            Toast.makeText(MainActivity.this,"电竞选项更改为"+stringBuilder+",少玩遊戲多寫代碼",Toast.LENGTH_SHORT)
                                    .show();
                        }else {
                            cb_1.setTextColor(Color.BLACK);
                            Toast.makeText(MainActivity.this,"电竞选项更改为"+stringBuilder,Toast.LENGTH_SHORT)
                                    .show();
                        }
                        break;
                    case R.id.cb02:
                        Toast.makeText(MainActivity.this,"阅读选项更改为"+stringBuilder,Toast.LENGTH_SHORT)
                                .show();
                        break;
                    case R.id.cb03:
                        Toast.makeText(MainActivity.this,"运动选项更改为"+stringBuilder,Toast.LENGTH_SHORT)
                                .show();
                        break;
                }
        }
    }

    private class MyButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.True:
                    cb_1.setChecked(true);
                    cb_2.setChecked(true);
                    cb_3.setChecked(true);
                    break;
                case R.id.False:
                    cb_1.setChecked(false);
                    cb_2.setChecked(false);
                    cb_3.setChecked(false);
                    break;
                case R.id.Get:
                    List<String> list = new ArrayList<>();
                    if(cb_1.isChecked())
                        list.add(cb_1.getText().toString());
                    if(cb_2.isChecked())
                        list.add(cb_2.getText().toString());
                    if(cb_3.isChecked())
                        list.add(cb_3.getText().toString());
                    textView.setText(list.toString());
                    list.clear();
                    break;
            }
        }
    }
}
