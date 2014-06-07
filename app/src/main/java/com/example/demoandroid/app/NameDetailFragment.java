package com.example.demoandroid.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NameDetailFragment extends Fragment {

    private TextView txtName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_name_detail, null);
        txtName = (TextView) view.findViewById(R.id.txtName);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        if ( arguments != null )
        {
            String name = (String) arguments.get(MainActivity.TAG_NAME);
            setName(name);
        }

    }

    public void setName(String name)
    {
        if ( name != null )
        {
            txtName.setText(name);
        }
    }
}
