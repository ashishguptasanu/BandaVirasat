package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Feed_;
import ashish.com.BandaVirasat.Model.Place_;
import ashish.com.BandaVirasat.R;


public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.MyViewHolder> {
    private Context context;
    ArrayList<Feed_> feeds;
    public FeedsAdapter(Context context, List<Feed_> feeds) {
        this.feeds = (ArrayList<Feed_>) feeds;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFeeds;
        TextView tvShort, textTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            imgFeeds = (ImageView) itemView.findViewById(R.id.image_feed);
            tvShort = (TextView) itemView.findViewById(R.id.text_short_feed);
            textTime = (TextView) itemView.findViewById(R.id.text_time);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feed, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvShort.setText(feeds.get(position).getShortDescription());
        holder.textTime.setText(feeds.get(position).getTimeStamp());
        Picasso.with(context).load(feeds.get(position).getImageUrl()).into(holder.imgFeeds);
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }


}
