package com.example.zerlin.ui_pickers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private DatePicker datePicker;
    private TextView textView;
    private int Year,Month,Day,Hour,Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getCurrentTime();
        setPicker();
    }

    private void initView() {
        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.date_picker);
        textView = findViewById(R.id.text_view);
    }

    private void getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH);
        Day = calendar.get(Calendar.DATE);
        Hour = calendar.get(Calendar.HOUR);
        Minute = calendar.get(Calendar.MINUTE);
    }

    private void setPicker() {
        //时间为24小时制
        timePicker.setIs24HourView(true);
        //设置当前时间
        timePicker.setHour(Hour);
        timePicker.setMinute(Minute);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this,
                        "选中的时间为:"+i+"时"+i1+"分",
                        Toast.LENGTH_SHORT).show();

            }
        });
        datePicker.init(Year, Month, Day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this,
                        "选中的时间为:"+i+"年"+(i1+1)+"月"+i2+"日",
                        Toast.LENGTH_SHORT).show();
            }
        });
        StringBuilder stringBuilder = new StringBuilder(datePicker.getYear()
                +"/"+(datePicker.getMonth()+1)+"/"+datePicker.getDayOfMonth()+"   "
                +timePicker.getHour()+":"+timePicker.getMinute());
        textView.setText(stringBuilder);
    }

}
