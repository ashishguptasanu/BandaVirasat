package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Contact;
import ashish.com.BandaVirasat.Model.Place;
import ashish.com.BandaVirasat.Model.Place_;
import ashish.com.BandaVirasat.R;


public class AdapterNearBy extends RecyclerView.Adapter<AdapterNearBy.MyViewHolder> {
    private Context context;
    ArrayList<Place_> places;
    public AdapterNearBy(Context context, List<Place_> places) {
        this.places = (ArrayList<Place_>) places;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv1, tvDescription;
        ImageView imgNearBy;
        FloatingActionButton fabNearMe;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.tv_near_by);
            tvDescription = (TextView)itemView.findViewById(R.id.tv_near_by_description);
            fabNearMe = (FloatingActionButton)itemView.findViewById(R.id.fab_nearme);
            imgNearBy = (ImageView)itemView.findViewById(R.id.image_near_by);
            fabNearMe.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Uri gmmIntentUri = Uri.parse("google.navigation:q="+ places.get(getAdapterPosition()).getLat() + "," + places.get(getAdapterPosition()).getLong());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);

        }
    }
    @Override
    public AdapterNearBy.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nearby, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterNearBy.MyViewHolder holder, int position) {
        holder.tv1.setText(places.get(position).getPlaceName());
        holder.tvDescription.setText(places.get(position).getPlaceDescription());
        Picasso.with(context).load(places.get(position).getImageUrl()).into(holder.imgNearBy);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }


}
