package com.example.vivek.videohls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements adapter.OnUrlistener{
    String data[]={"https://player.vimeo.com/external/286837767.m3u8?s=42570e8c4a91b98cdec7e7bfdf0eccf54e700b69",
            "https://player.vimeo.com/external/286837810.m3u8?s=610b4fee49a71c2dbf22c017523 72ff1c6459b9e",
            "https://player.vimeo.com/external/286837723.m3u8?s=3df60d3c1c6c7a11df4047af99c5e05cc2e7ae96",
            "https://player.vimeo.com/external/286837649.m3u8?s=9e486e9b932be72a8875afc6ea ae21bab124a35a",
            "https://player.vimeo.com/external/286837529.m3u8?s=20f83af6ea8fbfc8ce0c2001f32bf 037f8b0f65f",
            "https://player.vimeo.com/external/286837402.m3u8?s=7e01c398e2f01c29ecbd46e5e2dd53e0d6c1905d",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView programmingList = (RecyclerView)findViewById(R.id.my_recycler_view);
        programmingList.setLayoutManager(new LinearLayoutManager(this));

        programmingList.setAdapter(new adapter(data, this));


    }

    @Override
    public void OnUrlClick(int position) {
        Intent intent = new Intent(this, Main2Activity.class);
        String send=data[position];
        Log.i("URl to be sent :",send);
        intent.putExtra("URL",send);
        startActivity(intent);

    }
}
