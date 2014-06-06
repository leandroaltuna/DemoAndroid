package com.example.demoandroid.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private final static String TAG = "Debug";
    private String statusMessage;
    private TextView txtMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Second Code
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        statusMessage = "Status: onCreate";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);

        Button btnOpen = (Button) findViewById(R.id.btnOpen);
        Button btnClose = (Button) findViewById(R.id.btnClose);

        btnOpen.setOnClickListener(new OpenButtonOnClickListener());
        btnClose.setOnClickListener(new CloseButtonOnClickListener());

        // First code
//        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
//
//        btnSubmit.setOnClickListener(new OnClickListener()
//       {
//            @Override
//            public void onClick(View v){
//                Toast.makeText(getApplicationContext(), "do click", Toast.LENGTH_SHORT).show();
//
//                EditText editName = (EditText) findViewById(R.id.editName);
//                TextView txtMsg = (TextView) findViewById(R.id.txtMsg);
//
//                txtMsg.setText("Hi " + editName.getText());
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        statusMessage = "Status: onDestroy";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);
    }

    @Override
    protected void onPause() {
        super.onPause();

        statusMessage = "Status: onPause";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        statusMessage = "Status: onRestart";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();

        statusMessage = "Status: onResume";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);
    }

    @Override
    protected void onStop() {
        super.onStop();

        statusMessage = "Status: onStop";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);
    }

    @Override
    protected void onStart() {
        super.onStart();

        statusMessage = "Status: onStart";
        txtMsg.setText(statusMessage);
        Log.d(TAG, statusMessage);
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

    class CloseButtonOnClickListener implements OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            finish();
        }
    }

    class OpenButtonOnClickListener implements OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            Intent intent_start = new Intent(getApplicationContext(), SecondActivity.class);
            startActivity(intent_start);
        }
    }

}
