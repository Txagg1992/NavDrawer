package com.curiousca.menus01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}