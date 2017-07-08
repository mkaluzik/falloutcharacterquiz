package com.example.android.falloutcharacterquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    CheckBox antidepresives ;
    CheckBox survivalKit ;
    CheckBox encyclopedia;
    CheckBox sunGlasses ;
    CheckBox nothing ;
    CheckBox stimpack ;
    CheckBox radiation ;
    CheckBox waiting;
    CheckBox buffout ;
    CheckBox poison ;
    RadioGroup radioGroup1 ;
    RadioGroup radioGroup2 ;
    RadioGroup radioGroup3 ;
    RadioGroup radioGroup4 ;
    RadioGroup radioGroup5 ;
    RadioGroup radioGroup6 ;
    RadioGroup radioGroup7 ;


    int score=0;
    String companyName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypefaceUtil.overrideFont(getApplicationContext(), "MONOSPACE", "fonts/monofont.ttf");

        buffout = (CheckBox)findViewById(R.id.answer1_health);
        waiting = (CheckBox)findViewById(R.id.answer2_health);
        poison = (CheckBox)findViewById(R.id.answer3_health);
        radiation = (CheckBox)findViewById(R.id.answer4_health);
        stimpack = (CheckBox)findViewById(R.id.answer5_health);
        antidepresives = (CheckBox)findViewById(R.id.antidepresives);
        survivalKit = (CheckBox)findViewById(R.id.survival_kit);
        encyclopedia = (CheckBox)findViewById(R.id.encyclopedia);
        sunGlasses = (CheckBox)findViewById(R.id.sun_glasses);
        nothing = (CheckBox)findViewById(R.id.nothing);
        radioGroup1 = (RadioGroup) findViewById(R.id.rg_q1);
        radioGroup2 = (RadioGroup) findViewById(R.id.rg_q2);
        radioGroup3 = (RadioGroup) findViewById(R.id.rg_q3);
         radioGroup4 = (RadioGroup) findViewById(R.id.rg_q4);
         radioGroup5 = (RadioGroup) findViewById(R.id.rg_q5);
        radioGroup6 = (RadioGroup) findViewById(R.id.rg_q6);
        radioGroup7 = (RadioGroup) findViewById(R.id.rg_q7);

    }

    // Quiz part check

    public void quiz_check(View view){
// Let's check the company name correct answer is Interplay Entertainment
        EditText developerName = (EditText) this.findViewById(R.id.company_name_question);
        companyName = developerName.getText().toString();
    if (companyName.equals("Interplay Entertainment")){
        score++;

}
// Second question check
        if(radioGroup6.getCheckedRadioButtonId()==R.id.answer2_pip){
            score++;

    }
        // Third question check
        if(radioGroup7.getCheckedRadioButtonId()==R.id.answer3_cow){
            score++;

        }
        // Fourth question check
        if ((buffout.isChecked() && waiting.isChecked() && stimpack.isChecked())&&(!poison.isChecked() && !radiation.isChecked())){
            score++;
        }


        Toast.makeText(getApplicationContext(), "You have "+score+" correct answers out of 4", Toast.LENGTH_SHORT).show();

        score=0;
    }

    public void check(View view){

        //Let's check 1st answer

         EditText userName = (EditText) this.findViewById(R.id.name);
         name = userName.getText().toString();

        RadioGroup radioGroup;
        //Let's check 2nd answer

        if(radioGroup1.getCheckedRadioButtonId()==R.id.male){
            sex="male";
        } else { sex ="female";}


        //Let's check the 3rd answer

        if(radioGroup2.getCheckedRadioButtonId()==R.id.answer1_problems){
            actionMan++;
        } else if (radioGroup2.getCheckedRadioButtonId()==R.id.answer2_problems){
            getLostType++;

        } else if (radioGroup2.getCheckedRadioButtonId()==R.id.answer3_problems) {
            mrNoBigDeal++;


        } else if (radioGroup2.getCheckedRadioButtonId()==R.id.answer4_problems){
            ouchieType++;

        } else {
            brainiac++;


    }

        //Let's check the 4th answer

        if(radioGroup3.getCheckedRadioButtonId()==R.id.answer1_responsibility){
            mrNoBigDeal++;
        } else if (radioGroup3.getCheckedRadioButtonId()==R.id.answer2_responsibility){
            getLostType++;

        } else if (radioGroup3.getCheckedRadioButtonId()==R.id.answer3_responsibility) {
            ouchieType++;


        } else if (radioGroup3.getCheckedRadioButtonId()==R.id.answer4_responsibility){
            brainiac++;

        } else {
            actionMan++;


        }


        //Let's check the 5th answer(s)



        if (antidepresives.isChecked())  ouchieType++;


        if (survivalKit.isChecked())  actionMan++;


        if (encyclopedia.isChecked())   brainiac++;


        if (sunGlasses.isChecked())    mrNoBigDeal++;


        if (nothing.isChecked())     getLostType++;

        //Let's check the 6th answer

        if(radioGroup4.getCheckedRadioButtonId()==R.id.answer1_party){
            brainiac++;
        } else if (radioGroup4.getCheckedRadioButtonId()==R.id.answer2_party){
            actionMan++;

        } else if (radioGroup4.getCheckedRadioButtonId()==R.id.answer3_party) {
            ouchieType++;


        } else if (radioGroup4.getCheckedRadioButtonId()==R.id.answer4_party){
            getLostType++;

        } else {
            mrNoBigDeal++;


        }


        //Let's check the 7th answer

        if(radioGroup5.getCheckedRadioButtonId()==R.id.answer1_fear){
            getLostType++;
        } else if (radioGroup5.getCheckedRadioButtonId()==R.id.answer2_fear){
            actionMan++;

        } else if (radioGroup5.getCheckedRadioButtonId()==R.id.answer3_fear) {
            mrNoBigDeal++;

        } else if (radioGroup5.getCheckedRadioButtonId()==R.id.answer4_fear){
            ouchieType++;

        } else {
            brainiac++;


        }
String character="";
String resultCharacter="";

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
                character="actionman";
                resultCharacter="Action man";
                break;
            case 1:
                character="ouchietype";
                resultCharacter="Ouchie";
                break;
            case 2:
                character="brainiac";
                resultCharacter="Braniac";
                break;
            case 3:
                character="getlosttype";
                resultCharacter="Runner";
                break;
            case 4:
                character="mrnobigdeal";
                resultCharacter="Mr. NoBigDeal";
                break;

        }




String msg = "Action man is "+actionMan+", getLost is "+getLostType+", mrNoBD is "+mrNoBigDeal+", Ouichie is "+ouchieType+", braniac is "+brainiac+", Name and sex is "+name+" "+sex+" Character is "+character;

        // Add into log as Info message
        Log.i("test", msg);



        // Intent with key->value pairs provided to new activity
        Intent generateCharacter = new Intent(getApplicationContext(), DisplayCharacter.class);

        generateCharacter.putExtra("name",name);
        generateCharacter.putExtra("sex",sex);
        generateCharacter.putExtra("character",character);
        generateCharacter.putExtra("resultCharacter",resultCharacter);
        // Start the new activity
        startActivity(generateCharacter);


}}
