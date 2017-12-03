package com.example.bevil.hitchbot;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button yesButt;
    Button noButt;
    private TextView alertTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        yesButt = (Button) findViewById(R.id.yesButt);
        yesButt.setOnClickListener(new View.OnClickListener(){
            /** Called when the user taps the YES button */
            @Override
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, instructions.class);
                startActivity(myIntent);
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

