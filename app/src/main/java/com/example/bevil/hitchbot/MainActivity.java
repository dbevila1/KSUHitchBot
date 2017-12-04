package com.example.bevil.hitchbot;

import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
//import com.ibm.watson.developer_cloud.text_to_speech;
import com.ibm.watson.developer_cloud.android.library.audio.StreamPlayer;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;


public class MainActivity extends AppCompatActivity {

    Button yesButt;
    Button noButt;
    private TextView alertTextView;
    final TextToSpeech service = new TextToSpeech();
    boolean startRan = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        service.setUsernameAndPassword("d1cf2d4d-343b-4b54-9994-e00348150272", "fzXb1TaXRIHr");

        Thread thread = new Thread(new Runnable(){
            public void run() {

                try {
                    List<Voice> voices = service.getVoices().execute();
                    System.out.println(voices);

                    StreamPlayer streamPlayer = new StreamPlayer();
                    if (!startRan == true) {
                        streamPlayer.playStream(service.synthesize(String.valueOf("<voice-transformation type=\"Young\" strength=\"100%\" pitch=\"70%\"> Hello there! Can you help me? </voice-transformation>"), Voice.EN_MICHAEL).execute());
                        startRan = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        yesButt = (Button) findViewById(R.id.yesButt);
        yesButt.setOnClickListener(new View.OnClickListener(){
            /** Called when the user taps the YES button */
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, instructions.class);
                startActivity(myIntent);

                service.setUsernameAndPassword("d1cf2d4d-343b-4b54-9994-e00348150272", "fzXb1TaXRIHr");

                Thread thread = new Thread(new Runnable(){
                    public void run() {

                        try {
                            List<Voice> voices = service.getVoices().execute();
                            System.out.println(voices);

                            StreamPlayer streamPlayer = new StreamPlayer();
                            streamPlayer.playStream(service.synthesize(String.valueOf("<voice-transformation type=\"Young\" strength=\"100%\" pitch=\"70%\"> Hurray! Thanks! I need to get to the Math building. Would you be willing to take me there?> </voice-transformation>"), Voice.EN_MICHAEL).execute());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();

            }



        });

        noButt = (Button) findViewById(R.id.noButt);
        noButt.setOnClickListener(new View.OnClickListener(){
            /** Called when the user taps the NO button */
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Thank you anyways!");
                builder.setMessage("Have a great day!");

                service.setUsernameAndPassword("d1cf2d4d-343b-4b54-9994-e00348150272", "fzXb1TaXRIHr");

                Thread thread = new Thread(new Runnable(){
                    public void run() {

                        try {
                            List<Voice> voices = service.getVoices().execute();
                            System.out.println(voices);

                            StreamPlayer streamPlayer = new StreamPlayer();
                            streamPlayer.playStream(service.synthesize(String.valueOf("<voice-transformation type=\"Young\" strength=\"100%\" pitch=\"70%\"> Aww, okay. Thank you anyways. </voice-transformation>"), Voice.EN_MICHAEL).execute());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();

                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertTextView.setVisibility(View.VISIBLE);
                    }
                });
                builder.show();
            }
        });

    }

}

