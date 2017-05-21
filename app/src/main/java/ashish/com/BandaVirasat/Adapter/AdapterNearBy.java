package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Contact;
import ashish.com.BandaVirasat.R;


public class AdapterNearBy extends RecyclerView.Adapter<AdapterNearBy.MyViewHolder> {

    private Context context;
    String[] myDataSet;
    public AdapterNearBy(Context context, String[] myDataSet) {
        this.myDataSet = myDataSet;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv1;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView)itemView.findViewById(R.id.tv_near_by);
        }

        @Override
        public void onClick(View v) {

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
        holder.tv1.setText(myDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return myDataSet.length;
    }


}
