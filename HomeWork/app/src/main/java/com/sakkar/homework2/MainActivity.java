package com.sakkar.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView1,textView2,textView3;
    Button button;
    int startCount=0,createCount=0,resumeCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateAll();

        createCount+=1;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        startCount=savedInstanceState.getInt("StartCount");
        createCount=savedInstanceState.getInt("CreateCount");
        resumeCount=savedInstanceState.getInt("ResumeCount");
    }

    @Override
    protected void onStart() {
        super.onStart();
        startCount+=1;
    }

    @Override
    protected void onResume() {
        super.onStart();
        resumeCount+=1;
        showAll();
    }

    private void showAll() {
        textView1.setText(getString(R.string.oncreate_initiated)+" "+createCount+"Times");
        textView2.setText(getString(R.string.onstart_initiated)+" "+startCount+"Times");
        textView3.setText(getString(R.string.onresume_initiated)+" "+resumeCount+"Times");
    }

    private void initiateAll() {
        textView1= (TextView) findViewById(R.id.onCreate);
        textView2= (TextView) findViewById(R.id.onStart);
        textView3= (TextView) findViewById(R.id.onResume);
        button= (Button) findViewById(R.id.goto2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StartCount",startCount);
        outState.putInt("CreateCount",createCount);
        outState.putInt("ResumeCount",resumeCount);
    }
}
