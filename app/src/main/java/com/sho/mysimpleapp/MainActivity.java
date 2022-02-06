package com.sho.mysimpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int _minNum = 1;
    private int _maxNum = 10;

    private Button mGenerateButton;
    private TextView mGeneratedNumView;
    private EditText mMinNumView;
    private EditText mMaxNumView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGenerateButton = (Button) findViewById(R.id.generate_button);
        mGeneratedNumView = (TextView) findViewById(R.id.generated_num);
        mMinNumView = (EditText) findViewById(R.id.txtMinNum);
        mMaxNumView = (EditText) findViewById(R.id.txtMaxNum);

        mGeneratedNumView.setText("0");
        mMinNumView.setText("0");
        mMaxNumView.setText("6");

        // EVENTS
        mGenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _minNum = Integer.parseInt(String.valueOf(mMinNumView.getText()));
                _maxNum = Integer.parseInt(String.valueOf(mMaxNumView.getText()));

                int randNum = GenerateRandomNum(_minNum, _maxNum);
                mGeneratedNumView.setText(String.valueOf(randNum));
            }
        });
    }

    private int GenerateRandomNum(int minNum, int maxNum){
        int randomNum = (int)(Math.random()*(maxNum-minNum+1)+minNum);
        return randomNum;
    }
}