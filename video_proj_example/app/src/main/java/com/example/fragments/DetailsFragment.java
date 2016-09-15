package com.example.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.disney.myapplication.Video;
import com.example.disney.myapplication.VideoActivity;
import com.example.test.video_proj_example.R;

public class DetailsFragment extends Fragment {
    private Video video;

    public DetailsFragment(Video video) {
        this.video = video;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        TextView videoName = (TextView) view.findViewById(R.id.video_title);
        videoName.setText(video.getmVideoName());
        ImageView videoImage = (ImageView) view.findViewById(R.id.video_image);
        if (video.getmImageId() != 0) {
            videoImage.setImageResource(video.getmImageId());
        }
        TextView descriptionTextView = (TextView) view.findViewById(R.id.detailed_info);
        descriptionTextView.setText(video.getmDescription());
        ((VideoActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((VideoActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
