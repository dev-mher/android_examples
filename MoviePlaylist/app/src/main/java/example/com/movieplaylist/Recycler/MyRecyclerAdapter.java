package example.com.movieplaylist.Recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import example.com.movieplaylist.Description;
import example.com.movieplaylist.MainActivity;
import example.com.movieplaylist.R;

/**
 * Created by mher on 9/25/16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context ctx;
    ArrayList<Movie> movies;

    public MyRecyclerAdapter(Context ctx, ArrayList<Movie> movies) {
        this.ctx = ctx;
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setImageResource(movies.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent((MainActivity)ctx, Description.class);
                intent.putExtra("description",movies.get(position).getDescription());
                ((MainActivity) ctx).startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
