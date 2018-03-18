package com.example.zerlin.ui_radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg;
    private ToggleButton tb;
    private ImageView iv;
    private SeekBar sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView(){
        rg = findViewById(R.id.radio_g);
        /*RadioButton rb1 = findViewById(R.id.radio_b1);
        RadioButton rb2 = findViewById(R.id.radio_b2);*/
        tb = findViewById(R.id.toggle_b);
        iv = findViewById(R.id.image_v);
        sb = findViewById(R.id.seek_b);
    }

    private void setListener(){
        MyCheckedChangeListener myCheckedChangeListener = new MyCheckedChangeListener();
        rg.setOnCheckedChangeListener(myCheckedChangeListener);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton toggleButton = (ToggleButton) view;
                if(toggleButton.isChecked()) {
                    Toast.makeText(MainActivity.this,
                            tb.getText().toString(), Toast.LENGTH_SHORT)
                            .show();
                    iv.setImageResource(R.drawable.happy);
                }else {
                    Toast.makeText(MainActivity.this,
                            tb.getText().toString(), Toast.LENGTH_SHORT)
                            .show();
                    iv.setImageResource(R.drawable.unhappy);
                }
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this,
                        "现在是"+sb.getProgress()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,
                        "开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,
                        "结束", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i/*radioGroup.getId()*/){
                case R.id.radio_b1:
                    Toast.makeText(MainActivity.this,
                            "先生您好",Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.radio_b2:
                    Toast.makeText(MainActivity.this,
                            "女士您好",Toast.LENGTH_SHORT)
                            .show();
                    break;
            }
        }
    }
}
