package com.example.android9.Activitys;

import static com.example.android9.R.drawable.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android9.Adapters.ImageListAdapter;
import com.example.android9.Clicks.ImageClick;
import com.example.android9.R;

public class QuotesActivity extends AppCompatActivity {

    int imgArray[] = {back,back2,back3,back4,back5,back6,back7};
    private static final String TAG = "QuotesActivity";
RecyclerView imgList;
    TextView txtQuote;
    ImageView backImage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        txtQuote = findViewById(R.id.txtQuote);
        imgList = findViewById(R.id.imgList);
        backImage = findViewById(R.id.backImage);

        String quote = getIntent().getStringExtra("quote");
        txtQuote.setText(quote);

        ImageClick click = new ImageClick() {
            @Override
            public void getImage(int pos) {
                Glide.with(QuotesActivity.this).load(imgArray[pos]).into(backImage);
            }
        };

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        ImageListAdapter adapter = new ImageListAdapter(imgArray,click);
        imgList.setLayoutManager(manager);
        imgList.setAdapter(adapter);

    }
}