package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button button;
    TextView text;
    String opG = "", opD = "";
    String op = "";
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = (Button) findViewById(R.id.button2);
        text = (TextView) findViewById(R.id.textView);
    }

    public void changeValue(View v){
        button = (Button) findViewById(v.getId());
        text = (TextView) findViewById(R.id.textView);
        if (v.getId()==R.id.button17){
            text.setText("");
            op="";
            opG ="";
            opD ="";
        }else {
            if (op.isEmpty()) {
                opG =opG + (String) button.getText();
                text.setText(opG);
            } else {
                opD = opD + (String) button.getText();
                text.setText(opG +" "+ op + " " + opD);
            }
        }
    }

    public double operation(){
        double y = 0.0;
        if (op.equals("+")){
            y = Float.valueOf(opD) + Float.valueOf(opG);
        }
        if (op.equals("-")){
            y = Float.valueOf(opG) - Float.valueOf(opD);
        }
        if (op.equals("*")){
            y = Float.valueOf(opD) * Float.valueOf(opG);
        }
        if (op.equals("/")){
            y = Float.valueOf(opG) / Float.valueOf(opD);
        }
        return y;
    }


    public void readOperation(View v){
        if (v.getId()==R.id.button15) {
            text.setText(String.valueOf(operation()));
            op = "";
            opD ="";
            opG ="";
        }
        else {
            if (v.getId() == R.id.button11) {
                if (op.isEmpty()){
                    opG = opG.substring(0,opG.length()-1);
                }
                else{
                    if (opD.isEmpty()) {op = "";}
                    else{opD = opD.substring(0,opD.length()-1);}
                }
                String s = opG +" " + op + " " + opD;
                text.setText(s);
            } else {
                button = (Button) findViewById(v.getId());
                text = (TextView) findViewById(R.id.textView);
                text.setText(opG + " " + button.getText());
                op = (String) button.getText();
            }
        }
    }

}

