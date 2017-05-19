package ashish.com.BandaVirasat.Adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ashish.com.BandaVirasat.Activity.HomeActivity;
import ashish.com.BandaVirasat.Model.Contact;
import ashish.com.BandaVirasat.R;
import gun0912.tedbottompicker.TedBottomPicker;


public class AdapterContact extends RecyclerView.Adapter<AdapterContact.MyViewHolder> {
    private Context context;
    ArrayList<Contact> contacts;

    public AdapterContact(Context context, List<Contact> contacts) {
        this.contacts = (ArrayList<Contact>) contacts;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView call, mail, massage;
        public TextView mTextView1, mTextView2, mTextView3, mTextView4;

        public MyViewHolder(View v) {
            super(v);
            mTextView1 = (TextView) v.findViewById(R.id.contact_profession);
            mTextView2 = (TextView) v.findViewById(R.id.contact_name);
            mTextView3 = (TextView) v.findViewById(R.id.contact_address);
            //mTextView4 = (TextView) v.findViewById(R.id.contact_number);
            call = (ImageView) v.findViewById(R.id.call_phone);
            call.setOnClickListener(this);
            massage = (ImageView) v.findViewById(R.id.send_massage);
            massage.setOnClickListener(this);
            mail = (ImageView) v.findViewById(R.id.send_mail);
            mail.setOnClickListener(this);
            //img = (ImageView)v.findViewById(R.id.dial);
            //img.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.call_phone:
                    String num = contacts.get(getAdapterPosition()).getContactNumber();
                    callPhone(num);
                    break;
                case R.id.send_massage:
                    String number = contacts.get(getAdapterPosition()).getContactNumber();
                    sendMessage(number);
                    break;
                case R.id.send_mail:
                    sendMail("ashishguptajiit@gmail.com");
                    break;

            }


        }

        private void sendMail(String s) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, s);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
            context.startActivity(Intent.createChooser(intent, "Send Email"));
        }

        private void sendMessage(String num) {
            Intent intentt = new Intent(Intent.ACTION_VIEW);
            intentt.setData(Uri.parse("sms:"));
            intentt.setType("vnd.android-dir/mms-sms");
            //intentt.putExtra(Intent.EXTRA_TEXT, "");
            intentt.putExtra("address", num);
            ((Activity) context).startActivityForResult(Intent.createChooser(intentt, "Choose SMS App"), 0);
        }

        private void callPhone(String num) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + String.valueOf(num)));
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
        //holder.mTextView4.setText(contacts.get(position).getContactNumber());

    }
    @Override
    public int getItemCount() {
        return this.contacts.size();

    }
}
