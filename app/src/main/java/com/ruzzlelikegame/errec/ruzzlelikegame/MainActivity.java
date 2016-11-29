package com.ruzzlelikegame.errec.ruzzlelikegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView outputTextView;
    TextView scoreTextView;
    TrieSET set = new TrieSET();
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputTextView = (TextView)findViewById(R.id.outputTxt);
        scoreTextView = (TextView)findViewById(R.id.scoreTxt);
        set.add("word");
        set.add("test");
    }


    public void btnClick(View view){
        Button bt = (Button)view;

        if(outputTextView.getText().length() > 15){
            return;
        }
        outputTextView.setText(outputTextView.getText() + bt.getText().toString()); // TextView.append() method not working
    }


    public void submitClick(View view){
        boolean found = false;
        String word = outputTextView.getText().toString().toLowerCase();

        for (String s : set.keysThatMatch(word)) {
            found = true;
        }

        if(found){
            Toast.makeText(MainActivity.this, "\nword " + word.toUpperCase() + " found!", Toast.LENGTH_SHORT).show();
            score += 10;
            scoreTextView.setText(String.valueOf(score) + "points");
            outputTextView.setText("");
        }else{
            Toast.makeText(MainActivity.this, "\nword " + word.toUpperCase() + " not found!", Toast.LENGTH_SHORT).show();
            score -= 10;
            scoreTextView.setText(String.valueOf(score) + "points");
            outputTextView.setText("");
        }
    }
}
