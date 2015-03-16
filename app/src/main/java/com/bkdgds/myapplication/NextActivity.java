package com.bkdgds.myapplication;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class NextActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView location = (TextView)findViewById(R.id.greeting);
        location.setText("hello " + name);

        String[] genericStatuses = new String[] {"I'm bored", "Hey! Check out my 37th selfie...for the day", "Spam! Spam!","#tbt to last Thursday...","Depressing song lyric","pseudo intellectual quote", "PITY MEEEE!!!!!", "I ate food! Look at it! It's food!","'Sublte' insult at obvious person","MOARR ATTENTION!!"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, genericStatuses);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String loc = "";
        try {
            List<Address> address = geocoder.getFromLocation(91.35, -10.5, 1);
            loc = address.get(0).getCountryName();
        } catch(Exception e) {

        }
        TextView textView = (TextView)findViewById(R.id.location);
        textView.setText(loc);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
