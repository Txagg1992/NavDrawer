package com.curiousca.menus01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,
            editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et2);

        registerForContextMenu(editText1);
        registerForContextMenu(editText2);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id){
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
                break;

            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_LONG).show();
                break;

            case R.id.save:
                Toast.makeText(MainActivity.this, "File saved", Toast.LENGTH_LONG).show();
                break;

            case R.id.contact:
                Toast.makeText(MainActivity.this, "Contact us", Toast.LENGTH_LONG).show();
                break;

            case R.id.search:
                Toast.makeText(MainActivity.this, "Look over there", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){

            case R.id.et1:
                getMenuInflater().inflate(R.menu.edit1, menu);
                break;

            case R.id.et2:
                getMenuInflater().inflate(R.menu.edit2_menu, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.etm1:
                Toast.makeText(MainActivity.this, "Click Menu 1, Item 1",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.etm2:
                Toast.makeText(MainActivity.this, "Click Menu 1, Item 2",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.second1:
                Toast.makeText(MainActivity.this, "Click Menu 2, Item 1",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.second2:
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
