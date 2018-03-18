package com.example.zerlin.optionsmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private float textSize = 20.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater menuInflater = getMenuInflater();
        //menuInflater.inflate(R.menu.main,menu);
        getMenuInflater().inflate(R.menu.main,menu);
        //直接使用java代码创建
        menu.add(Menu.NONE,4,5,R.string.text_change);
        menu.add(Menu.NONE,5,5,R.string.exit);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.text_sizeSet:
                Toast.makeText(this, "改变字体大小",
                        Toast.LENGTH_SHORT).show();
                textSize+=5;
                textView.setTextSize(textSize);
                break;
            case R.id.text_colorSet:
                Toast.makeText(this, "改变字体颜色",
                        Toast.LENGTH_SHORT).show();
                int r = (int)(Math.random()*256);
                int g = (int)(Math.random()*256);
                int b = (int)(Math.random()*256);
                textView.setTextColor(Color.rgb(r,g,b));
                break;
            case R.id.text_styleSet:
                Toast.makeText(this, "改变字体风格",
                        Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "改变字体粗细",
                        Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "退出",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_first:
                Toast.makeText(this, "first",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.text_second:
                Toast.makeText(this, "second",
                        Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
