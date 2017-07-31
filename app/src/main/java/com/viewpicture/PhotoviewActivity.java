package com.viewpicture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bluemobi.dylan.photoview.library.PhotoView;

public class PhotoviewActivity extends AppCompatActivity {

    @Bind(R.id.photoview)
    PhotoView photoview;

    String Ulr;//接收网址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photoview);
        ButterKnife.bind(this);

        Ulr = getIntent().getStringExtra("url");

        Glide.with(PhotoviewActivity.this).load(Ulr).into(photoview);
    }
}