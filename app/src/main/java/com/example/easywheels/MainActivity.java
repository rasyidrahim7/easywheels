package com.example.easywheels;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adjust padding for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize data and set adapter
        List<Vehicle> vehicles = initializeVehicles();
        VehicleAdapter adapter = new VehicleAdapter(vehicles);
        recyclerView.setAdapter(adapter);

        // Set click listener for the location icon
        ImageView locationIcon = findViewById(R.id.locationIcon);
        locationIcon.setOnClickListener(v -> openGoogleMaps());
    }

    private void openGoogleMaps() {
        // Create a Uri for the Google Maps location (example: open New York City)
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=New+York+City");

        // Create an Intent to launch Google Maps
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        // Verify that the intent will resolve to an activity
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    private List<Vehicle> initializeVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        // Car
        List<Vehicle.Subcategory> carSubcategories = new ArrayList<>();
        carSubcategories.add(new Vehicle.Subcategory("Sedan", Arrays.asList(
                new Vehicle.Subcategory.Model("Honda Civic", "RM 250", "RM 220", R.drawable.civic1, R.drawable.civic2),
                new Vehicle.Subcategory.Model("Toyota Vios", "RM 180", "RM 170", R.drawable.vios1, R.drawable.vios2)
        )));
        carSubcategories.add(new Vehicle.Subcategory("Hatchback", Arrays.asList(
                new Vehicle.Subcategory.Model("Perodua Myvi", "RM 120", "RM 130", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Proton Iriz", "RM 120", "RM 140", R.drawable.iriz1, R.drawable.iriz2),
                new Vehicle.Subcategory.Model("Honda City Hatchback", "RM 150", "RM 165", R.drawable.city1, R.drawable.city2)
        )));
        carSubcategories.add(new Vehicle.Subcategory("SUV", Arrays.asList(
                new Vehicle.Subcategory.Model("Proton X70", "RM 250", "RM 240", R.drawable.x701, R.drawable.x701),
                new Vehicle.Subcategory.Model("Honda CR-V", "RM 280", "RM 265", R.drawable.crv1, R.drawable.crv2)
        )));

        // Motorcycle
        List<Vehicle.Subcategory> motorcycleSubcategories = new ArrayList<>();
        motorcycleSubcategories.add(new Vehicle.Subcategory("Sport", Arrays.asList(
                new Vehicle.Subcategory.Model("Yamaha R1", "RM 600 ", "RM 650", R.drawable.r1, R.drawable.r12),
                new Vehicle.Subcategory.Model("Honda CBR600RR", "RM 700", "RM 750", R.drawable.cbr1, R.drawable.cbr2)
        )));
        motorcycleSubcategories.add(new Vehicle.Subcategory("Cruiser", Arrays.asList(
                new Vehicle.Subcategory.Model("Harley Davidson Street 750", "RM 1200", "RM 1400", R.drawable.harley1, R.drawable.harley1),
                new Vehicle.Subcategory.Model("Royal Enfield Classic 350", "RM 1100", "RM 1300", R.drawable.royal1, R.drawable.royal1)
        )));
        motorcycleSubcategories.add(new Vehicle.Subcategory("Scooter", Arrays.asList(
                new Vehicle.Subcategory.Model("Vespa Primavera", "RM 60", "RM 70", R.drawable.vespa1, R.drawable.vespa2),
                new Vehicle.Subcategory.Model("Honda Vario", "RM 40", "RM 45", R.drawable.vario1, R.drawable.vario2)
        )));

        // Bus
        List<Vehicle.Subcategory> busSubcategories = new ArrayList<>();
        busSubcategories.add(new Vehicle.Subcategory("Mini Bus", Arrays.asList(
                new Vehicle.Subcategory.Model("Toyota Coaster", "RM 2000", "RM 2200", R.drawable.coester1, R.drawable.coester2),
                new Vehicle.Subcategory.Model("Nissan Civilian", "RM 2500", "RM 2700", R.drawable.nissan1, R.drawable.nissan1)
        )));
        busSubcategories.add(new Vehicle.Subcategory("Double Decker", Arrays.asList(
                new Vehicle.Subcategory.Model("Volvo B11R", "RM 2200", "RM 2300", R.drawable.volvobus1, R.drawable.volvobus2),
                new Vehicle.Subcategory.Model("Scania K410", "RM 3000", "RM 3500", R.drawable.volvobus2, R.drawable.volvobus1)
        )));
        busSubcategories.add(new Vehicle.Subcategory("City Bus", Arrays.asList(
                new Vehicle.Subcategory.Model("Mercedes-Benz Citaro", "RM 7000", "RM 7500", R.drawable.man1, R.drawable.man2),
                new Vehicle.Subcategory.Model("MAN Lion’s City", "RM 7500", "RM 8000", R.drawable.man2, R.drawable.man1)
        )));

        // Lorry
        List<Vehicle.Subcategory> lorrySubcategories = new ArrayList<>();
        lorrySubcategories.add(new Vehicle.Subcategory("Pickup", Arrays.asList(
                new Vehicle.Subcategory.Model("Ford Ranger", "RM 400", "RM 400", R.drawable.ford1, R.drawable.ford2),
                new Vehicle.Subcategory.Model("Toyota Hilux", "RM 300", "RM 300", R.drawable.hilux1, R.drawable.hilux2)
        )));
        lorrySubcategories.add(new Vehicle.Subcategory("Box Truck", Arrays.asList(
                new Vehicle.Subcategory.Model("Hino 300 Series", "RM 1500", "RM 1600", R.drawable.hino1, R.drawable.hino2),
                new Vehicle.Subcategory.Model("Fuso Canter", "RM 1300", "RM 1400", R.drawable.fuso1, R.drawable.fuso2)
        )));
        lorrySubcategories.add(new Vehicle.Subcategory("Trailer", Arrays.asList(
                new Vehicle.Subcategory.Model("Volvo FH16", "RM 5000", "RM 5500", R.drawable.volvo1, R.drawable.volvo2),
                new Vehicle.Subcategory.Model("Scania R500", "RM 5500", "RM 6000", R.drawable.scania2, R.drawable.scania1)
        )));

        // Add vehicles to the list
        vehicles.add(new Vehicle(R.drawable.kereta, "Car", carSubcategories));
        vehicles.add(new Vehicle(R.drawable.motor, "Motorcycle", motorcycleSubcategories));
        vehicles.add(new Vehicle(R.drawable.bas, "Bus", busSubcategories));
        vehicles.add(new Vehicle(R.drawable.lori, "Lorry", lorrySubcategories));

        return vehicles;
    }
}