package com.example.demoandroid.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    public final static ArrayList<String> names = new ArrayList<String>();
    public final static String TAG_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editName = (EditText) findViewById(R.id.editName);
        ListView listOfNames = (ListView) findViewById(R.id.listOfNames);
        Button btnAddName = (Button) findViewById(R.id.btnAddName);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, names );

        listOfNames.setAdapter(adapter);
        btnAddName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                Log.d("TAG", name);
                if ( !names.contains(name) )
                {
                    Log.d("TAG", "Name add");
                    names.add(name);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        listOfNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String itemName = adapter.getItem(i);

                if ( getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT )
                {
                    Intent intentAction = new Intent(getApplicationContext(), NameDetailActivity.class);
                    intentAction.putExtra(TAG_NAME, itemName);
                }
                else
                {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    NameDetailFragment fragment = (NameDetailFragment) fragmentManager.findFragmentById(R.id.detailFragment);
                    fragment.setName(itemName);
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
