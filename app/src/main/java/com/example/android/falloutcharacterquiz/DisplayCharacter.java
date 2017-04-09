package com.example.android.falloutcharacterquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_character);
        String s="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String sex = extras.getString("sex");
            String name = extras.getString("name");
            String character=extras.getString("character");
            s = name+" "+sex+" "+character;
        }
        TextView test = (TextView) this.findViewById(R.id.testText);
        test.setText(s);
    }



}
