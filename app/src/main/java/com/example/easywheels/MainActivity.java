package com.example.easywheels;

import android.os.Bundle;
import android.view.View;

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
    }

    private List<Vehicle> initializeVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        // Car
        List<Vehicle.Subcategory> carSubcategories = new ArrayList<>();
        carSubcategories.add(new Vehicle.Subcategory("Sedan", Arrays.asList(
                new Vehicle.Subcategory.Model("Honda Civic", "RM 120", "RM 140", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Toyota Vios", "RM 140", "RM 160", R.drawable.myvi2, R.drawable.myvi)
        )));
        carSubcategories.add(new Vehicle.Subcategory("Hatchback", Arrays.asList(
                new Vehicle.Subcategory.Model("Perodua Myvi", "RM 120", "RM 130", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Proton Iriz", "RM 45,000", "RM 50,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Honda City Hatchback", "RM 60,000", "RM 65,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        carSubcategories.add(new Vehicle.Subcategory("SUV", Arrays.asList(
                new Vehicle.Subcategory.Model("Proton X70", "RM 100,000", "RM 110,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Honda CR-V", "RM 150,000", "RM 160,000", R.drawable.myvi2, R.drawable.myvi)
        )));

        // Motorcycle
        List<Vehicle.Subcategory> motorcycleSubcategories = new ArrayList<>();
        motorcycleSubcategories.add(new Vehicle.Subcategory("Sport", Arrays.asList(
                new Vehicle.Subcategory.Model("Yamaha R1", "RM 80,000", "RM 85,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Honda CBR600RR", "RM 70,000", "RM 75,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        motorcycleSubcategories.add(new Vehicle.Subcategory("Cruiser", Arrays.asList(
                new Vehicle.Subcategory.Model("Harley Davidson Street 750", "RM 60,000", "RM 65,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Royal Enfield Classic 350", "RM 40,000", "RM 45,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        motorcycleSubcategories.add(new Vehicle.Subcategory("Scooter", Arrays.asList(
                new Vehicle.Subcategory.Model("Vespa Primavera", "RM 20,000", "RM 22,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Honda Vario", "RM 18,000", "RM 20,000", R.drawable.myvi2, R.drawable.myvi)
        )));

        // Bus
        List<Vehicle.Subcategory> busSubcategories = new ArrayList<>();
        busSubcategories.add(new Vehicle.Subcategory("Mini Bus", Arrays.asList(
                new Vehicle.Subcategory.Model("Toyota Coaster", "RM 200,000", "RM 220,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Nissan Civilian", "RM 250,000", "RM 270,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        busSubcategories.add(new Vehicle.Subcategory("Double Decker", Arrays.asList(
                new Vehicle.Subcategory.Model("Volvo B11R", "RM 600,000", "RM 650,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Scania K410", "RM 650,000", "RM 700,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        busSubcategories.add(new Vehicle.Subcategory("City Bus", Arrays.asList(
                new Vehicle.Subcategory.Model("Mercedes-Benz Citaro", "RM 700,000", "RM 750,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("MAN Lion’s City", "RM 750,000", "RM 800,000", R.drawable.myvi2, R.drawable.myvi)
        )));

        // Lorry
        List<Vehicle.Subcategory> lorrySubcategories = new ArrayList<>();
        lorrySubcategories.add(new Vehicle.Subcategory("Pickup", Arrays.asList(
                new Vehicle.Subcategory.Model("Ford Ranger", "RM 100,000", "RM 110,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Toyota Hilux", "RM 120,000", "RM 130,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        lorrySubcategories.add(new Vehicle.Subcategory("Box Truck", Arrays.asList(
                new Vehicle.Subcategory.Model("Hino 300 Series", "RM 150,000", "RM 160,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Fuso Canter", "RM 130,000", "RM 140,000", R.drawable.myvi2, R.drawable.myvi)
        )));
        lorrySubcategories.add(new Vehicle.Subcategory("Trailer", Arrays.asList(
                new Vehicle.Subcategory.Model("Volvo FH16", "RM 500,000", "RM 550,000", R.drawable.myvi2, R.drawable.myvi),
                new Vehicle.Subcategory.Model("Scania R500", "RM 550,000", "RM 600,000", R.drawable.myvi2, R.drawable.myvi)
        )));

        // Add vehicles to the list
        vehicles.add(new Vehicle(R.drawable.kereta, "Car", carSubcategories));
        vehicles.add(new Vehicle(R.drawable.motor, "Motorcycle", motorcycleSubcategories));
        vehicles.add(new Vehicle(R.drawable.bas, "Bus", busSubcategories));
        vehicles.add(new Vehicle(R.drawable.lori, "Lorry", lorrySubcategories));

        return vehicles;
    }
}