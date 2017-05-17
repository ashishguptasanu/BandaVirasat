package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ashish.com.BandaVirasat.Model.Detail_;
import ashish.com.BandaVirasat.R;

/**
 * Created by ashish on 21/12/16.
 */

public class AdapterDialog extends RecyclerView.Adapter<AdapterDialog.MyViewHolder> {
    Context context;
    ArrayList<Detail_> details;



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1,mTextView2,mTextView3;
        public MyViewHolder(View v) {
            super(v);
            mTextView1 = (TextView) v.findViewById(R.id.stopage);
            mTextView2 = (TextView) v.findViewById(R.id.arrival_time);
            mTextView3 = (TextView) v.findViewById(R.id.departure_time);
        }
    }
    public AdapterDialog(Context context, ArrayList<Detail_> details) {
        this.details = details;
        this.context = context;

    }
    @Override
    public AdapterDialog.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.travel_dialog_content, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterDialog.MyViewHolder holder, int position) {

        holder.mTextView1.setText(details.get(position).getStopage());
        holder.mTextView2.setText(details.get(position).getArrival());
        holder.mTextView3.setText(details.get(position).getDeparture());
    }
    @Override
    public int getItemCount() {
        return this.details.size();

    }
}
