package com.example.zerlin.ui_pickershomework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class PickActivity extends AppCompatActivity {

    private EditText editText;
    private RadioGroup radioGroup;
    //private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkBoxSpicy,checkBoxSeafood,checkBoxSour;
    private SeekBar seekBar;
    private Button buttonSearch;
    private ImageView imageView;
    private ToggleButton toggleButton;
    private List<Food> lists_food;
    private List<Food> lists_search;
    private boolean spicy,seafood,sour;
    private Person person;
    private int price;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);
        initView();
        initDate();
        setListener();
    }

    private void initView(){
        editText = findViewById(R.id.edit_view);
        radioGroup = findViewById(R.id.radio_group);
        //radioButtonMale = findViewById(R.id.radio_button_male);
        //radioButtonFemale = findViewById(R.id.radio_button_female);
        checkBoxSpicy = findViewById(R.id.checkbox_spicy);
        checkBoxSeafood = findViewById(R.id.checkbox_seafood);
        checkBoxSour = findViewById(R.id.checkbox_sour);
        seekBar = findViewById(R.id.seek_bar);
        buttonSearch = findViewById(R.id.button_search);
        imageView = findViewById(R.id.image_view);
        toggleButton = findViewById(R.id.toggle_button);

    }

    private void initDate(){
        person = new Person();
        person.setName(editText.getText().toString());
        lists_food = new ArrayList<>();
        lists_search = new ArrayList<>();
        lists_food.add(new Food("DVA01",false,true,false,52,R.drawable.dva01));
        lists_food.add(new Food("DVA02",true,false,true,18,R.drawable.dva02));
        lists_food.add(new Food("DVA03",false,true,false,53,R.drawable.dva03));
        lists_food.add(new Food("DVA04",true,true,true,64,R.drawable.dva04));
        lists_food.add(new Food("DVA05",false,false,false,12,R.drawable.dva05));
        lists_food.add(new Food("DVA06",true,true,false,94,R.drawable.dva06));
        lists_food.add(new Food("DVA07",false,false,true,76,R.drawable.dva07));
        //lists_food.add(new Food("NTY01",true,true,true,35,R.drawable.nty01));
        //lists_food.add(new Food("NTY02",false,false,true,48,R.drawable.nty02));
        //lists_food.add(new Food("NTY03",true,true,false,74,R.drawable.nty03));
        lists_food.add(new Food("NTY04",false,false,false,22,R.drawable.nty04));
        lists_food.add(new Food("NTY05",true,false,true,92,R.drawable.nty05));
        lists_food.add(new Food("NTY06",false,true,false,15,R.drawable.nty06));
        //lists_food.add(new Food("NTY07",true,false,false,35,R.drawable.nty07));
        lists_food.add(new Food("HXJ01",true,true,true,42,R.drawable.hxj01));
        lists_food.add(new Food("HXJ02",false,false,true,62,R.drawable.hxj02));
        lists_food.add(new Food("HXJ03",false,true,false,35,R.drawable.hxj03));
        lists_food.add(new Food("HXJ04",true,false,false,64,R.drawable.hxj04));
        lists_food.add(new Food("HXJ05",false,true,true,58,R.drawable.hxj05));
        lists_food.add(new Food("HXJ06",true,true,false,34,R.drawable.hxj06));
        lists_food.add(new Food("HXJ07",false,false,false,59,R.drawable.hxj07));
        spicy = false;
        seafood = false;
        sour = false;
        price = seekBar.getProgress();
        num = 0;
    }

    private void setListener(){
        MyRadioGroupListener myRadioGroupListener = new MyRadioGroupListener();
        radioGroup.setOnCheckedChangeListener(myRadioGroupListener);
        MyCheckBoxListener myCheckBoxListener = new MyCheckBoxListener();
        checkBoxSpicy.setOnCheckedChangeListener(myCheckBoxListener);
        checkBoxSeafood.setOnCheckedChangeListener(myCheckBoxListener);
        checkBoxSour.setOnCheckedChangeListener(myCheckBoxListener);
        MySeekBarChangeListener mySeekBarChangeListener = new MySeekBarChangeListener();
        seekBar.setOnSeekBarChangeListener(mySeekBarChangeListener);
        MyButtonListener myButtonListener = new MyButtonListener();
        buttonSearch.setOnClickListener(myButtonListener);
        toggleButton.setOnClickListener(myButtonListener);

    }

    private void searchData(){
        for (Food food:lists_food
             ) {
            if((food.getPrice()<=price)
                    &&(food.isSpicy() == spicy)
                    &&(food.isSeafood() == seafood)
                    &&(food.isSour() == sour)){
                lists_search.add(food);
            }
        }
    }

    private void showPicture(int count){
        imageView.setImageResource(lists_search.get(count).getPicture());
    }

    private void clearAll(){
        lists_search.clear();
        num = 0;
    }

    class MyRadioGroupListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i){
                case R.id.radio_button_male:
                    person.setSex("男");
                    Toast.makeText(PickActivity.this,
                            "男士您好", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radio_button_female:
                    person.setSex("女");
                    Toast.makeText(PickActivity.this,
                            "女士您好", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    class MyCheckBoxListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            clearAll();
            CheckBox checkBox = (CheckBox)compoundButton;
            switch(checkBox.getId()){
                case R.id.checkbox_spicy:
                    spicy = b;
                    Toast.makeText(PickActivity.this,
                            "您"+b+"喜欢吃辣", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_seafood:
                    seafood = b;
                    Toast.makeText(PickActivity.this,
                            "您"+b+"喜欢吃海鲜", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_sour:
                    sour = b;
                    Toast.makeText(PickActivity.this,
                            "您"+b+"喜欢吃酸一点的", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    class MySeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            clearAll();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(PickActivity.this,
                    "默认为"+price+"元", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            price = seekBar.getProgress();
            Toast.makeText(PickActivity.this,
                    "您的预算是"+seekBar.getProgress()+"元", Toast.LENGTH_SHORT).show();

        }
    }

    class MyButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button_search:
                    searchData();
                    if(lists_search.size() == 0){
                        Toast.makeText(PickActivity.this, "没找到适合的菜品",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showPicture(num);
                    break;
                case R.id.toggle_button:
                    if(lists_search.size() == 0){
                        Toast.makeText(PickActivity.this, "没找到适合的菜品",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(toggleButton.isChecked()){
                        Toast.makeText(PickActivity.this,lists_search
                                .get(num++).toString(), Toast.LENGTH_LONG).show();
                    }else {
                        if(num == lists_search.size())
                            num = 0;
                        showPicture(num);
                    }
                    break;
            }
        }
    }
}
