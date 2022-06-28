package com.example.settlelahwaisiong;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.settlelahwaisiong.R;
import com.example.settlelahwaisiong.SampleDataProvider2;

import java.io.IOException;
import java.io.InputStream;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvName, tvCapital, tvDesc, tvPopulation;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        String cityId=getIntent().getStringExtra(com.example.settlelahwaisiong.MyDataAdapter.ITEM_KEY);

        initViews();

        displayCityData(cityId);


    }

    private void initViews() {

        this.tvName = findViewById(R.id.tv_name);
        this.tvCapital = findViewById(R.id.tv_capital);
        this.tvDesc = findViewById(R.id.tv_desc);
        this.tvPopulation = findViewById(R.id.tv_population);
        this.imageView = findViewById(R.id.imageView);

    }

    private void displayCityData(String cityId) {
        com.example.settlelahwaisiong.CityDataItem item= SampleDataProvider.dataItemMap.get(cityId);

        this.tvName.setText(item.getCityName());
        this.tvPopulation.setText(String.valueOf(item.getPopulation()));
        this.tvCapital.setText(item.getProvince());
        this.tvDesc.setText(item.getDescription());

        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(item.getImage());
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            this.imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream == null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
