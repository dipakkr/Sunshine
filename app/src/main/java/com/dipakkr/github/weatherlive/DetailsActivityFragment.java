package com.dipakkr.github.weatherlive;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {

    public DetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details,container,false);
        TextView textView = (TextView)view.findViewById(R.id.txt_detail_forecast);

        Intent intent = getActivity().getIntent();
        if(intent !=null & intent.hasExtra(Intent.EXTRA_TEXT)){
            String txt_forecast = intent.getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(txt_forecast);
        }
        return view;

    }
}
