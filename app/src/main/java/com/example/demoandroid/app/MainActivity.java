package com.example.demoandroid.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity implements SendDataDialogFragment.DialogListener {

    private boolean favorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        switch (item.getItemId())
        {
            case R.id.actionFav:
                Drawable icon = null;

                if ( favorite )
                {
                    icon = getResources().getDrawable(R.drawable.ic_action_not_important);
                }
                else
                {
                    icon = getResources().getDrawable(R.drawable.ic_action_important);
                }

                favorite = !favorite;
                item.setIcon(icon);
                return true;

            case R.id.actionShare:
                Intent shareIntent = new Intent();

                shareIntent.setAction(Intent.ACTION_SEND);
                String msgShare = getResources().getString(R.string.msgShare);
                Uri imgShare = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + R.drawable.hotel1);

                shareIntent.putExtra(Intent.EXTRA_TEXT, msgShare);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imgShare);

                shareIntent.setType("image/jpeg");

                startActivity(Intent.createChooser(shareIntent, "Share"));
                return true;

            case R.id.actionDialog:
                SendDataDialogFragment sendDialogFragment = new SendDataDialogFragment();
                sendDialogFragment.show(getSupportFragmentManager(), "Dialogo");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void toggleClicked(View view)
    {
        Log.d("TAG", "toggle");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Log.d("TAG", "say yes");
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}

class SendDataDialogFragment extends DialogFragment
{
    public interface DialogListener
    {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    DialogListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try
        {
            listener = (DialogListener) activity;
        }
        catch (ClassCastException e)
        {
            // nothing
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle("Title").setSingleChoiceItems(R.array.dialogOptions, -1, null)
                     .setPositiveButton(R.string.msgOn, new DialogInterface.OnClickListener(){

                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                            listener.onDialogPositiveClick(SendDataDialogFragment.this);
                         }

                     });

        return dialogBuilder.create();
    }
}