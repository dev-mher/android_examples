package com.example.disney.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fragments.DetailsFragment;
import com.example.test.video_proj_example.R;

import java.util.ArrayList;

public class VideoAdapter extends ArrayAdapter<Video> {

    private final ArrayList<Video> videos;
    private final Context context;
    private final FragmentManager manager;

    public VideoAdapter(Activity context, int resource, ArrayList<Video> videos, FragmentManager manager) {
        super(context, resource, videos);
        this.videos = videos;
        this.context = context;
        this.manager = manager;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        }
        TextView videoName = (TextView) convertView.findViewById(R.id.video_name);
        TextView videoNumber = (TextView) convertView.findViewById(R.id.video_number);
        videoNumber.setText(String.valueOf(videos.get(position).getmNumber()));
        videoName.setText(videos.get(position).getmVideoName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DetailsFragment(videos.get(position));
                if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    manager.beginTransaction().addToBackStack("details").replace(R.id.fragment_container_p, fragment).commit();
                } else if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    manager.beginTransaction().addToBackStack("details").replace(R.id.fragment_container_ld, fragment).commit();
                }
            }
        });
        return convertView;
    }
}
