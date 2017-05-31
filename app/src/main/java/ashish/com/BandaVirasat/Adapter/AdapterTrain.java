package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Train;
import ashish.com.BandaVirasat.Model.Train_;
import ashish.com.BandaVirasat.R;

/**
 * Created by ashish on 23/5/17.
 */

public class AdapterTrain extends RecyclerView.Adapter<AdapterTrain.MyViewHolder> {
    private Context context;
    ArrayList<Train_> trains;

    public AdapterTrain(Context context, List<Train_> trains) {
        this.trains = (ArrayList<Train_>) trains;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTrainNum, tvTrainName, tvTrainFrom, tvTrainTo, tvTrainFromName, tvTrainToName, tvTrainDay;
        RatingBar mRatingBar;
        public MyViewHolder(View v) {
            super(v);
            tvTrainNum = (TextView)itemView.findViewById(R.id.tv_train_num);
            tvTrainName = (TextView) itemView.findViewById(R.id.train_name);
            mRatingBar = (RatingBar)itemView.findViewById(R.id.rating_bar);
            tvTrainFrom = (TextView)itemView.findViewById(R.id.train_from);
            tvTrainFromName = (TextView)itemView.findViewById(R.id.train_from_name);
            tvTrainToName = (TextView)itemView.findViewById(R.id.train_to_name);
            tvTrainTo = (TextView)itemView.findViewById(R.id.train_to);
            tvTrainDay = (TextView)itemView.findViewById(R.id.train_days);
            mRatingBar.setNumStars(5);
            mRatingBar.setMax(5);
            mRatingBar.setStepSize((float) 0.5);



        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public AdapterTrain.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_train, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)  {
        holder.tvTrainNum.setText(trains.get(position).getTrainNumber());
        holder.mRatingBar.setRating(trains.get(position).getRating());
        holder.tvTrainName.setText(trains.get(position).getTrainName());
        holder.tvTrainFrom.setText(trains.get(position).getTrainFromCode());
        holder.tvTrainTo.setText(trains.get(position).getTrainToCode());
        holder.tvTrainFromName.setText(trains.get(position).getTrainFromName());
        holder.tvTrainToName.setText(trains.get(position).getTrainToName());
        holder.tvTrainDay.setText(trains.get(position).getDays());

    }
    @Override
    public int getItemCount() {
        return trains.size();

    }
}
