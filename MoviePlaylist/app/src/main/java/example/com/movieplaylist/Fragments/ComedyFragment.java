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
public class ComedyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.comedy_fragment, null);
        //RecyclerView
        RecyclerView rw = (RecyclerView) v.findViewById(R.id.comedyRecyclerView);
        rw.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rw.setAdapter(new MyRecyclerAdapter(this.getActivity(), getComedyMovies()));
        return v;
    }

    private ArrayList<Movie> getComedyMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Central Intelligence (2016)","Central Intelligence is a 2016 American action comedy film directed by Rawson Marshall Thurber and written by Thurber, Ike Barinholtz and David Stassen.", R.drawable.centralintelligence));
        movies.add(new Movie("Bad Moms (2016)","Bad Moms is a 2016 American comedy film directed and written by Jon Lucas and Scott Moore.", R.drawable.badmoms));
        return movies;
    }

    @Override
    public String toString() {
        return "Comedy";
    }
}
