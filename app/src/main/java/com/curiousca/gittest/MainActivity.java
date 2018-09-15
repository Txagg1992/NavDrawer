package com.curiousca.gittest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.git_test_button);
    }


    public void gitTest(View view) {

        textView.setText("I WIN!!");

        button.setBackgroundColor(Color.GREEN);
        button.setText("Success");
    }
}
