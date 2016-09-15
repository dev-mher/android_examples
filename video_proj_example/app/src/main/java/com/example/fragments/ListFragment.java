package com.example.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.disney.myapplication.Video;
import com.example.disney.myapplication.VideoActivity;
import com.example.disney.myapplication.VideoAdapter;
import com.example.test.video_proj_example.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ArrayList<Video> videoList;
    private Button seeMoreBtn;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((VideoActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(false);
        ((VideoActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        videoList = new ArrayList<>();
        for (int i = 0; i < 17; ++i) {
            videoList.add(new Video("Video", i, "Here will be the decription of video", R.mipmap.ic_video_image));
        }
        listView = (ListView) view.findViewById(R.id.listview);
        seeMoreBtn = new Button(getActivity());
        seeMoreBtn.setText(R.string.button_more_info);
        seeMoreBtn.setTextSize(20);
        seeMoreBtn.setGravity(Gravity.CENTER_HORIZONTAL);
        listView.addFooterView(seeMoreBtn);
        onClickEachItem();
        onClickButton();
        return view;
    }

    private void onClickButton() {
        seeMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DetailsFragment(videoList.get(1));
                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_p, fragment).addToBackStack("details").commit();
            }
        });
    }

    private void onClickEachItem() {
        final VideoAdapter adapter = new VideoAdapter(this.getActivity(),R.layout.list_fragment, videoList, getFragmentManager());
        listView.setAdapter(adapter);

    }
}
