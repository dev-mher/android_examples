package example.com.movieplaylist.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.com.movieplaylist.R;
import example.com.movieplaylist.Recycler.Movie;
import example.com.movieplaylist.Recycler.MyRecyclerAdapter;

/**
 * Created by mher on 9/25/16.
 */
public class ThrillerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thriller_fragment, null);

        //RecyclerView
        RecyclerView rw = (RecyclerView) v.findViewById(R.id.thrillerRecyclerView);
        rw.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rw.setAdapter(new MyRecyclerAdapter(this.getActivity(), getComedyMovies()));
        return v;
    }

    private ArrayList<Movie> getComedyMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Thriller 1","Description", android.R.drawable.presence_video_away));
        movies.add(new Movie("Thriller 2","Description", android.R.drawable.presence_video_away));

        return movies;
    }

    @Override
    public String toString() {
        return "Thriller";
    }
}
