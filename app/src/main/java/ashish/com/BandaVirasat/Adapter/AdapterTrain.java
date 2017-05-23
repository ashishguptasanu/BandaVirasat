package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Train;
import ashish.com.BandaVirasat.R;

/**
 * Created by ashish on 23/5/17.
 */

public class AdapterTrain extends RecyclerView.Adapter<AdapterTrain.MyViewHolder> {
    private Context context;
    ArrayList<Train> trains;

    public AdapterTrain(Context context, List<Train> trains) {
        this.trains = (ArrayList<Train>) trains;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MyViewHolder(View v) {
            super(v);

        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public AdapterTrain.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)  {


    }
    @Override
    public int getItemCount() {
        return trains.size();

    }
}
