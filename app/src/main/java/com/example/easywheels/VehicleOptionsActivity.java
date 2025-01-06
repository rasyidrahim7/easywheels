package com.example.easywheels;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_options);

        // Get the data passed from the previous activity
        String vehicleTitle = getIntent().getStringExtra("vehicleTitle");
        String vehiclePrice = getIntent().getStringExtra("vehiclePrice");
        int vehicleImageResId = getIntent().getIntExtra("vehicleImageResId", 0);

        // Set the title
        TextView titleTextView = findViewById(R.id.vehicleTitle);
        titleTextView.setText(vehicleTitle);

        // Set the price
        TextView priceTextView = findViewById(R.id.vehiclePrice);
        priceTextView.setText(vehiclePrice);

        // Set the image
        ImageView vehicleImageView = findViewById(R.id.vehicleImage);
        vehicleImageView.setImageResource(vehicleImageResId);
    }
}