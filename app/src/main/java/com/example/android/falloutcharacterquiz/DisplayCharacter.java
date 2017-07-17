package com.example.android.falloutcharacterquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.falloutcharacterquiz.R.id.char_type_image;

public class DisplayCharacter extends AppCompatActivity {
    String sex = "";
    String name = "";
    String resultCharacter = "";
    String character = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_character);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            sex = extras.getString("sex");
            name = extras.getString("name");
            resultCharacter = extras.getString("resultCharacter");
            character = extras.getString("character");
        }
        TextView charName = (TextView) this.findViewById(R.id.char_name);
        charName.setText("Name: " + name);
        TextView charSex = (TextView) this.findViewById(R.id.char_sex);
        charSex.setText("Sex: " + sex);
        TextView charType = (TextView) this.findViewById(R.id.char_type);
        charType.setText("Character type: " + resultCharacter);
        int id = getResources().getIdentifier(character, "drawable", getPackageName());
        ImageView image = (ImageView) findViewById(char_type_image);

        image.setImageResource(id);

    }


}
