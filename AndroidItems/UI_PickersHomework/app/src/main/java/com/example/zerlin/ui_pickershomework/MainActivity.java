package com.example.zerlin.ui_pickershomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private RadioGroup radioGroup;
    private RadioButton radioButton_1,radioButton_2,radioButton_3;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView textView_words,textView_time;
    private int Year,Month,Day,Hour,Minute;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getCurrentTime();
        setToggleButton();
        setRadioGroup();
        setCurrentTime();
        setCloseButton();

    }

    private void initView(){
        toggleButton = findViewById(R.id.toggle_button);
        radioGroup = findViewById(R.id.radio_group);
        radioButton_1 = findViewById(R.id.radio_button_working);
        radioButton_2 = findViewById(R.id.radio_button_talking);
        radioButton_3 = findViewById(R.id.radio_button_gaming);
        linearLayout = findViewById(R.id.linear_layout);
        imageView = findViewById(R.id.image_view);
        textView_words = findViewById(R.id.text_view_words);
        textView_time = findViewById(R.id.text_view_time);
        button = findViewById(R.id.button_close);

    }

    private void getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DATE);
        Hour = calendar.get(Calendar.HOUR);
        Minute = calendar.get(Calendar.MINUTE);

    }

    private void setToggleButton(){
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toggleButton.isChecked()){
                    Toast.makeText(MainActivity.this,
                            "打开了WiFi", Toast.LENGTH_SHORT)
                            .show();
                    radioGroup.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this,
                            "关闭了WiFi", Toast.LENGTH_SHORT)
                            .show();
                    radioGroup.clearCheck();
                    radioGroup.setVisibility(View.INVISIBLE);
                    linearLayout.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                linearLayout.setVisibility(View.VISIBLE);
                switch(i){
                    case R.id.radio_button_working:
                        imageView.setImageResource(R.drawable.working);
                        textView_words.setText("工作时间请认真工作！");
                        break;
                    case R.id.radio_button_talking:
                        imageView.setImageResource(R.drawable.talking);
                        textView_words.setText("会议时间请认真听取他人意见！");
                        break;
                    case R.id.radio_button_gaming:
                        imageView.setImageResource(R.drawable.gaming);
                        textView_words.setText("想玩什么随便你！");
                        break;

                }
            }
        });
    }

    private void setCurrentTime(){
        StringBuilder stringBuilder = new StringBuilder("现在时间"
                +Year+"/"+(Month+1)+"/"+Day+"    "
                +Hour+":"+Minute);
        textView_time.setText(stringBuilder);
    }

    private void setCloseButton(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
