package com.example.android.falloutcharacterquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    int actionMan=0;
    int brainiac=0;
    int getLostType = 0;
    int ouchieType = 0;
    int mrNoBigDeal = 0;
    String name ="";
    String sex ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypefaceUtil.overrideFont(getApplicationContext(), "MONOSPACE", "fonts/monofont.ttf");

    }

    public void check(View view){

        //Let's check 1st answer

        

        RadioGroup radioGroup;
        //Let's check 2nd answer
        radioGroup = (RadioGroup) findViewById(R.id.rg_q1);
        if(radioGroup.getCheckedRadioButtonId()==R.id.male){
            sex="Male";
        } else { sex ="Female"}


        //Let's check the 3rd answer
        radioGroup = (RadioGroup) findViewById(R.id.rg_q2);
        if(radioGroup.getCheckedRadioButtonId()==R.id.answer1_problems){
            actionMan++;
        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer2_problems){
            getLostType++;

        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer3_problems) {
            mrNoBigDeal++;


        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer4_problems){
            ouchieType++;

        } else {
            brainiac++;


    }






}
