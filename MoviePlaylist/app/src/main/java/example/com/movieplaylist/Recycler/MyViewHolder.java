package example.com.movieplaylist.Recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import example.com.movieplaylist.R;

/**
 * Created by mher on 9/25/16.
 */
public class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView img;
    TextView nameTxt;
    View itemView;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        img = (ImageView) itemView.findViewById(R.id.movieImage);
        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
    }
}
