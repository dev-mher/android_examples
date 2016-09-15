package com.example.disney.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.example.fragments.DetailsFragment;
import com.example.fragments.ListFragment;
import com.example.test.video_proj_example.R;


public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Fragment fragment = new ListFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        DetailsFragment fragmentDetails = new DetailsFragment(new Video("",0,"",0));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_p, fragment).commit();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ft.add(R.id.fragment_container_ll,fragment);
            ft.add(R.id.fragment_container_ld, fragmentDetails);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video, menu);
        return true;
    }
}


