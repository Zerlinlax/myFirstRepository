package com.example.zerlin.ui_progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.Toast;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button button_first,button_second;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        initView();
        setView();
    }

    private void initView(){
        progressBar = findViewById(R.id.progress_bar);
        button_first = findViewById(R.id.btn_first);
        button_second = findViewById(R.id.btn_second);
        ratingBar = findViewById(R.id.rating_bar);
    }

    private void setView(){
        MyClickListener myClickListener = new MyClickListener();
        button_first.setOnClickListener(myClickListener);
        button_second.setOnClickListener(myClickListener);
        MyRatingBarChangeListener myRatingBarChangeListener = new MyRatingBarChangeListener();
        ratingBar.setOnRatingBarChangeListener(myRatingBarChangeListener);
    }

    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            //view本身有getId方法，所以是不用转换的，
            // 但是像ToggleButton这样的getChanged方法就要转换的好
            switch (button.getId()){
                case R.id.btn_first:
                    progressBar.incrementProgressBy(10);
                    Toast.makeText(MainActivity.this,
                            "第一进度增加10", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_second:
                    progressBar.incrementSecondaryProgressBy(20);
                    Toast.makeText(MainActivity.this,
                            "第二进度增加20", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    class MyRatingBarChangeListener implements RatingBar.OnRatingBarChangeListener{

        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            Toast.makeText(MainActivity.this, "现在是"+v+"颗星", Toast.LENGTH_SHORT).show();
        }
    }
}
