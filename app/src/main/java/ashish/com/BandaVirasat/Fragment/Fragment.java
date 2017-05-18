package ashish.com.BandaVirasat.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ashish.com.BandaVirasat.Activity.HomeActivity;
import ashish.com.BandaVirasat.Adapter.AdapterContact;
import ashish.com.BandaVirasat.Adapter.AdapterTravel;
import ashish.com.BandaVirasat.Model.Contact;
import ashish.com.BandaVirasat.Model.Travel;
import ashish.com.BandaVirasat.Model.TravelResponse;
import ashish.com.BandaVirasat.Model.Travel_;
import ashish.com.BandaVirasat.R;
import gun0912.tedbottompicker.TedBottomPicker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;
import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by ashish on 4/12/16.
 */

public class Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private static final String LOG_TAG = "";
    String title;
    View view;
    RecyclerView recyclerView;
    AdapterContact adapterContact;
    AdapterTravel adapter3;
    AlertDialog.Builder dialogBuilder;
    AlertDialog b;
    Context context;
    EditText edt1,edt2,edt3,edt4;
    FloatingActionButton floatingActionButton;
    ImageView addImage;
    Canvas canvas;
        static String DB_URL = "https://banda-virasat-6812b.firebaseio.com/";
    int status = 0;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private List<Travel_> travel = new ArrayList<>();
    String travelUrl = "https://s3.ap-south-1.amazonaws.com";
    FirebaseDatabase mFirebaseDatabase;
    Firebase firebase;
    AmazonS3 s3;
    TransferUtility transferUtility;
    ObjectMetadata myObjectMetadata;

    public Fragment() {
    }
    public static Fragment newInstance(String title, String DB_URL){
        Fragment fragment1 = new Fragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment1.setArguments(args);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                getContext(),
                "us-west-2:95eece11-5f58-4843-a9b7-0d5da1719d1d", // Identity Pool ID
                Regions.US_WEST_2 // Region
        );
        s3 = new AmazonS3Client(credentialsProvider);
        transferUtility = new TransferUtility(s3, getContext());
        myObjectMetadata = new ObjectMetadata();

        Map<String, String> userMetadata = new HashMap<String,String>();
        userMetadata.put("key","value");

        myObjectMetadata.setUserMetadata(userMetadata);

    }

    public void saveOnline(String contactProfession, String contactName, String contactAddress, String contactNumber, int contactStatus){
        Contact contact = new Contact();
        contact.setContactProfession(contactProfession);
        contact.setContactName(contactName);
        contact.setContactAddress(contactAddress);
        contact.setContactNumber(contactNumber.toString());
        contact.setContactStatus(contactStatus);
        firebase.child("Contact").push().setValue(contact);
    }

    public void refreshData(){
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.w(TAG, "Failed to read value.", firebaseError.toException());
            }

        });
    }

    private void getUpdates(DataSnapshot dataSnapshot) {
        contacts.clear();
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
            Contact contact = new Contact();
            contact.setContactProfession(dataSnapshot1.getValue(Contact.class).getContactProfession());
            contact.setContactName(dataSnapshot1.getValue(Contact.class).getContactName());
            contact.setContactAddress(dataSnapshot1.getValue(Contact.class).getContactAddress());
            contact.setContactNumber(dataSnapshot1.getValue(Contact.class).getContactNumber());
            contact.setContactStatus(dataSnapshot1.getValue(Contact.class).getContactStatus());
            if(dataSnapshot1.getValue(Contact.class).getContactStatus() == 1){
                contacts.add(contact);
            }

        }
        Collections.reverse(contacts);
        if (getArguments() != null && getArguments().containsKey("title")) {
            if (title.equalsIgnoreCase("contact")) {
                context = getContext();
                adapterContact = new AdapterContact(context, contacts);
                recyclerView.setAdapter(adapterContact);
                LinearLayoutManager llm1 = new LinearLayoutManager(getActivity());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(llm1);
            }
        }
        contacts.size();
    }
    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        title = getArguments().getString("title");
        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShow();
            }
        });
        context = getContext();
        loadJson();
        initViews();
        SwipeRefreshLayout swipeLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_layout);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeLayout.isRefreshing();
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        }
        );

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        Firebase.setAndroidContext(getContext());
        firebase = new Firebase(DB_URL);
        refreshData();
        if(title.equalsIgnoreCase("contact")){
            floatingActionButton.setVisibility(View.VISIBLE);
        }
        else{
            floatingActionButton.setVisibility(View.GONE);
        }
    }
    public void initViews() {


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);

        adRequest();
    }


    private void adRequest() {
        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void dialogShow(){
        dialogBuilder = new AlertDialog.Builder(getContext());
        final View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_contact, null);
        edt1 = (EditText) dialogView.findViewById(R.id.edit1);
        edt2 = (EditText) dialogView.findViewById(R.id.edit2);
        edt3 = (EditText) dialogView.findViewById(R.id.edit3);
        edt4 = (EditText) dialogView.findViewById(R.id.edit4);
        addImage = (ImageView) dialogView.findViewById(R.id.add_image);
        addImage.setImageDrawable(getResources().getDrawable(R.drawable.add_photo));
        addImage.setOnClickListener(this);
        dialogBuilder.setTitle("Add Your Profile");
        dialogBuilder.setOnDismissListener(null);
        dialogBuilder.setIcon(R.mipmap.people_selected);
        dialogBuilder.setMessage("Note: Contacts will only show if approved by admin");
        dialogBuilder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                if(edt1.length() != 0  && edt2.length() !=0 && edt3.length() != 0 && edt4.length() != 0){
                    sendData();
                    Toast.makeText(getContext(),"Your request has been submitted, pending for approval", Toast.LENGTH_SHORT).show();
                    locallyNotify();
                }
                else{
                    Toast.makeText(getContext(),"Fill all fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        dialogBuilder.setView(dialogView);
        b = dialogBuilder.create();
        b.show();
    }
    private void sendData() {
        saveOnline(edt1.getText().toString(),edt2.getText().toString(),edt3.getText().toString(), edt4.getText().toString(), status);
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
    }
    private void locallyNotify() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.people_not_selected)
                        .setContentTitle("Profile Status")
                        .setContentText("Profile verification pending\n for approval by Admin");
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }

    private void loadJson(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(travelUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TravelResponse request = retrofit.create(TravelResponse .class);
        Call<Travel> call = request.getTravel();
        //
        call.enqueue(new Callback<Travel>() {
            @Override
            public void onResponse(Call<Travel> call, Response<Travel> response) {


                Travel jsonResponse = response.body();
                travel = jsonResponse.getTravel();
                if (getArguments() != null && getArguments().containsKey("title")) {


                    if (title.equalsIgnoreCase("Travel")) {
                        adapter3 = new AdapterTravel(context, travel);
                        recyclerView.setAdapter(adapter3);

                        LinearLayoutManager llm3 = new LinearLayoutManager(getActivity());
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(llm3);
                    }
                }
            }
            @Override
            public void onFailure(Call<Travel> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_image:
                TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(context)
                        .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                            @Override
                            public void onImageSelected(Uri uri) {
                                addImage.setImageURI(uri);
                                File file = new File(uri.getPath());
                                transferUtility.upload(
                                        "bandavirasat",        /* The bucket to upload to */
                                        file.getName(),       /* The key for the uploaded object */
                                        file,          /* The file where the data to upload exists */
                                        myObjectMetadata  /* The ObjectMetadata associated with the object*/
                                );
                            }
                        })
                        .create();

                tedBottomPicker.show(((HomeActivity)context).getSupportFragmentManager());
                break;
        }
    }

}


