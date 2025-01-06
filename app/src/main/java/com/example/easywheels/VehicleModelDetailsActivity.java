package com.example.easywheels;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleModelDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_model_details);

        // Get the data passed from the previous activity
        String modelName = getIntent().getStringExtra("modelName");
        String price1 = getIntent().getStringExtra("price1");
        String price2 = getIntent().getStringExtra("price2");
        int imageResId1 = getIntent().getIntExtra("imageResId1", 0);
        int imageResId2 = getIntent().getIntExtra("imageResId2", 0);

        // Set the model name
        TextView modelNameTextView = findViewById(R.id.modelNameTextView);
        modelNameTextView.setText(modelName);

        // Set the first price and image
        TextView priceTextView1 = findViewById(R.id.priceTextView1);
        priceTextView1.setText(price1);

        ImageView imageView1 = findViewById(R.id.imageView1);
        imageView1.setImageResource(imageResId1);

        // Set the second price and image
        TextView priceTextView2 = findViewById(R.id.priceTextView2);
        priceTextView2.setText(price2);

        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setImageResource(imageResId2);
    }
}