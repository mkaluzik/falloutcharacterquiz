package com.example.android.falloutcharacterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

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

         EditText userName = (EditText) this.findViewById(R.id.name);
         name = userName.getText().toString();

        RadioGroup radioGroup;
        //Let's check 2nd answer
        radioGroup = (RadioGroup) findViewById(R.id.rg_q1);
        if(radioGroup.getCheckedRadioButtonId()==R.id.male){
            sex="Male";
        } else { sex ="Female";}


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

        //Let's check the 4th answer
        radioGroup = (RadioGroup) findViewById(R.id.rg_q3);
        if(radioGroup.getCheckedRadioButtonId()==R.id.answer1_responsibility){
            mrNoBigDeal++;
        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer2_responsibility){
            getLostType++;

        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer3_responsibility) {
            ouchieType++;


        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer4_responsibility){
            brainiac++;

        } else {
            actionMan++;


        }


        //Let's check the 5th answer(s)

        CheckBox antidepresives = (CheckBox)findViewById(R.id.antidepresives);
        if (antidepresives.isChecked())  ouchieType++;

        CheckBox survivalKit = (CheckBox)findViewById(R.id.survival_kit);
        if (survivalKit.isChecked())  actionMan++;

        CheckBox encyclopedia = (CheckBox)findViewById(R.id.encyclopedia);
        if (encyclopedia.isChecked())   brainiac++;

        CheckBox sunGlasses = (CheckBox)findViewById(R.id.sun_glasses);
        if (sunGlasses.isChecked())    mrNoBigDeal++;

        CheckBox nothing = (CheckBox)findViewById(R.id.nothing);
        if (nothing.isChecked())     getLostType++;

        //Let's check the 6th answer
        radioGroup = (RadioGroup) findViewById(R.id.rg_q4);
        if(radioGroup.getCheckedRadioButtonId()==R.id.answer1_party){
            brainiac++;
        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer2_party){
            actionMan++;

        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer3_party) {
            ouchieType++;


        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer4_party){
            getLostType++;

        } else {
            mrNoBigDeal++;


        }


        //Let's check the 7th answer
        radioGroup = (RadioGroup) findViewById(R.id.rg_q5);
        if(radioGroup.getCheckedRadioButtonId()==R.id.answer1_fear){
            getLostType++;
        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer2_fear){
            actionMan++;

        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer3_fear) {
            mrNoBigDeal++;

        } else if (radioGroup.getCheckedRadioButtonId()==R.id.answer4_fear){
            ouchieType++;

        } else {
            brainiac++;


        }
String character="";

        int[] myList = {actionMan, ouchieType, brainiac, getLostType,mrNoBigDeal}; // action,ouchie,braniac,getLost,NoBigDeal
int indexOfHighest =0;
        int current=0;
        // Cycle through the array and find the biggest number
        for (int i = 0; i < myList.length; i++) {
            if (myList[i]>current){
                indexOfHighest=i;
                current=myList[i];
            }

        }

        switch (indexOfHighest){
            case 0:
                character="actionMan";
                break;
            case 1:
                character="ouchieType";
                break;
            case 2:
                character="brainiac";
                break;
            case 3:
                character="getLostType";
                break;
            case 4:
                character="mrNoBigDeal";
                break;

        }




String msg = "Action man is "+actionMan+" getLost is "+getLostType+" mrNoBD is "+mrNoBigDeal+" Ouichie is "+ouchieType+" braniac is "+brainiac+" Name and sex is "+name+" "+sex+" Character is "+character;

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        // Intent with key->value pairs provided to new activity
        Intent generateCharacter = new Intent(getApplicationContext(), DisplayCharacter.class);

        generateCharacter.putExtra("name",name);
        generateCharacter.putExtra("sex",sex);
        generateCharacter.putExtra("character",character);
        // Start the new activity
        startActivity(generateCharacter);


}}
