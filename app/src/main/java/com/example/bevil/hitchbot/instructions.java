package com.example.bevil.hitchbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

import java.util.List;

public class instructions extends AppCompatActivity {

    Button yesButt2;
    Button noButt2;
    final TextToSpeech service = new TextToSpeech();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);



        yesButt2 = (Button) findViewById(R.id.yesButt2);
        yesButt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(instructions.this, MapsActivity.class);
                startActivity(myIntent);

            }
        });

        noButt2 = (Button) findViewById(R.id.noButt2);
        noButt2.setOnClickListener(new View.OnClickListener(){
            /** Called when the user taps the YES button */
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(instructions.this, MainActivity.class);
                startActivity(myIntent);
            }
        });


    }
}
