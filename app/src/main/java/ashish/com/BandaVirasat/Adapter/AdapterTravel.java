package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Detail;
import ashish.com.BandaVirasat.Model.DetailResponse;
import ashish.com.BandaVirasat.Model.Detail_;
import ashish.com.BandaVirasat.Model.Travel_;
import ashish.com.BandaVirasat.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashish on 7/12/16.
 */

public class AdapterTravel extends RecyclerView.Adapter<AdapterTravel.MyViewHolder3>  {
    public Context context;
    int selectedCard;
    RecyclerView recyclerView;
    int position;
    AlertDialog dialog;
    ArrayList<Travel_> travel;
    private List<Detail_> details = new ArrayList<>();
    public AdapterTravel(Context context, List<Travel_> travel) {
        this.travel = (ArrayList<Travel_>) travel;
        this.context = context;
    }



    public class MyViewHolder3 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView1, mTextView2, mTextView3;


        public MyViewHolder3(View v) {
            super(v);
            mTextView1 = (TextView) v.findViewById(R.id.start_point);
            mTextView2 = (TextView) v.findViewById(R.id.end_point);
            mTextView3 = (TextView) v.findViewById(R.id.buses);

            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

            position = getAdapterPosition();
            String url = travel.get(getAdapterPosition()).getJsonUrl();
            loadJson(url);
            initViews();
        }
        private void initViews(){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            final View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_travel, null);
            recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler_dialog);
            dialogBuilder.setTitle("Bus Timings");
            dialogBuilder.setIcon(R.mipmap.travel_selected);
            dialogBuilder.setMessage("For more details, Call 139");
            dialogBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                }
            });
            dialogBuilder.setView(dialogView);
            dialog = dialogBuilder.create();
            recyclerView.setHasFixedSize(true);


            LinearLayoutManager llm = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(llm);
            dialog.show();

        }

        private void loadJson(String url) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://s3.ap-south-1.amazonaws.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            DetailResponse request = retrofit.create(DetailResponse.class);

            Call<Detail> call = request.getJSON(url);
            call.enqueue(new Callback<Detail>() {
                @Override
                public void onResponse(Call<Detail> call, Response<Detail> response) {
                    Detail jsonResponse = response.body();
                    details = jsonResponse.getDetail();
                    AdapterDialog adapterDialog = new AdapterDialog(context, (ArrayList<Detail_>) details);
                    recyclerView.setAdapter(adapterDialog);
                }

                @Override
                public void onFailure(Call<Detail> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                }
            });
        }


    }


    @Override
    public AdapterTravel.MyViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_travel, parent, false);
        AdapterTravel.MyViewHolder3 vh = new AdapterTravel.MyViewHolder3(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(AdapterTravel.MyViewHolder3 holder,int position) {
        holder.mTextView1.setText(travel.get(position).getFrom());
        holder.mTextView2.setText(travel.get(position).getTo());
        holder.mTextView3.setText(travel.get(position).getTotal_buses());
        selectedCard = holder.getAdapterPosition();


    }

    @Override
    public int getItemCount() {
        return travel.size();
    }













}
