package com.dipakkr.github.weatherlive;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsActivityFragment extends Fragment {

    private ShareActionProvider mShareActionProvider;
    String txt_forecast;


    public DetailsActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details,container,false);
        TextView textView = (TextView)view.findViewById(R.id.txt_detail_forecast);

        Intent intent = getActivity().getIntent();
        if(intent !=null & intent.hasExtra(Intent.EXTRA_TEXT)){
             txt_forecast = intent.getStringExtra(Intent.EXTRA_TEXT);
            textView.setText(txt_forecast);
        }

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail_frag_menu,menu);
        MenuItem item = menu.findItem(R.id.item_share);

        //using MenuItemCompat
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        if(mShareActionProvider != null){
            mShareActionProvider.setShareIntent(createShareIntent());
        }
    }

    private Intent createShareIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,txt_forecast + "#SunShineApp");
        return intent;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.item_share){

        }

        return super.onOptionsItemSelected(item);
    }
}
