package ashish.com.BandaVirasat.Activity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ashish.com.BandaVirasat.R;

public class FeedDetailActivity extends AppCompatActivity {
    TextView time, shortDescription, longDescription;
    ImageView imgFeedDetail;
    String imageUrl, shortDes, longDes, mTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        imageUrl = getIntent().getStringExtra("image_url");
        shortDes = getIntent().getStringExtra("short");
        longDes = getIntent().getStringExtra("long");
        mTime = getIntent().getStringExtra("time");
        initViews();

    }

    private void initViews() {
        imgFeedDetail = (ImageView) findViewById(R.id.img_feed_detail);
        Picasso.with(getApplicationContext()).load(imageUrl).into(imgFeedDetail);
        shortDescription = (TextView)findViewById(R.id.feed_detail_short);
        longDescription = (TextView)findViewById(R.id.feed_detail_long);
        time = (TextView)findViewById(R.id.feed_detail_time);
        shortDescription.setText(shortDes);
        longDescription.setText(longDes);
        time.setText(mTime);
    }
}
