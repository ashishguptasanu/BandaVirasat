package ashish.com.BandaVirasat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Model.Contact;
import ashish.com.BandaVirasat.R;


public class AdapterContact extends RecyclerView.Adapter<AdapterContact.MyViewHolder> {
    private Context context;
    ArrayList<Contact> contacts;
    public AdapterContact(Context context, List<Contact> contacts) {
        this.contacts = (ArrayList<Contact>) contacts;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        public TextView mTextView1,mTextView2,mTextView3,mTextView4;
        public MyViewHolder(View v) {
            super(v);
            mTextView1 = (TextView) v.findViewById(R.id.contact_profession);
            mTextView2 = (TextView) v.findViewById(R.id.contact_name);
            mTextView3 = (TextView) v.findViewById(R.id.contact_address);
            mTextView4 = (TextView) v.findViewById(R.id.contact_number);
            //img = (ImageView)v.findViewById(R.id.dial);
            //img.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            String num = contacts.get(getAdapterPosition()).getContactNumber();
            callPhone(num);
        }

        private void callPhone(String num) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse(String.valueOf(num)));
                context.startActivity(callIntent);
        }


    }

    @Override
    public AdapterContact.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)  {

        holder.mTextView1.setText(contacts.get(position).getContactProfession());
        holder.mTextView2.setText(contacts.get(position).getContactName());
        holder.mTextView3.setText(contacts.get(position).getContactAddress());
        holder.mTextView4.setText(contacts.get(position).getContactNumber());

    }
    @Override
    public int getItemCount() {
        return this.contacts.size();

    }
}
