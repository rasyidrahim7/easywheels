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
        carSubcategories.add(new Vehicle.Subcategory("Sedan", false, Arrays.asList("Honda Civic", "S70", "Vios")));
        carSubcategories.add(new Vehicle.Subcategory("Hatchback", false, Arrays.asList("Myvi", "Axia", "City Hatchback")));
        carSubcategories.add(new Vehicle.Subcategory("SUV", false, Arrays.asList("X70", "Ativa", "CR-V")));

        // Motorcycle
        List<Vehicle.Subcategory> motorcycleSubcategories = new ArrayList<>();
        motorcycleSubcategories.add(new Vehicle.Subcategory("Sport", false, Arrays.asList("Yamaha R1", "Honda CBR600RR", "Kawasaki Ninja ZX-6R")));
        motorcycleSubcategories.add(new Vehicle.Subcategory("Cruiser", false, Arrays.asList("Harley Davidson Street 750", "Royal Enfield Classic 350")));
        motorcycleSubcategories.add(new Vehicle.Subcategory("Scooter", false, Arrays.asList("Vespa Primavera", "Honda Vario", "Yamaha NMAX")));

        // Bus
        List<Vehicle.Subcategory> busSubcategories = new ArrayList<>();
        busSubcategories.add(new Vehicle.Subcategory("Mini Bus", false, Arrays.asList("Toyota Coaster", "Nissan Civilian")));
        busSubcategories.add(new Vehicle.Subcategory("Double Decker", false, Arrays.asList("Volvo B11R", "Scania K410")));
        busSubcategories.add(new Vehicle.Subcategory("City Bus", false, Arrays.asList("Mercedes-Benz Citaro", "MAN Lion’s City")));

        // Lorry
        List<Vehicle.Subcategory> lorrySubcategories = new ArrayList<>();
        lorrySubcategories.add(new Vehicle.Subcategory("Pickup", false, Arrays.asList("Ford Ranger", "Toyota Hilux", "Isuzu D-Max")));
        lorrySubcategories.add(new Vehicle.Subcategory("Box Truck", false, Arrays.asList("Hino 300 Series", "Fuso Canter", "Tata LPT")));
        lorrySubcategories.add(new Vehicle.Subcategory("Trailer", false, Arrays.asList("Volvo FH16", "Scania R500")));

        // Add vehicles to the list
        vehicles.add(new Vehicle(R.drawable.kereta, "Car", false, carSubcategories));
        vehicles.add(new Vehicle(R.drawable.motor, "Motorcycle", false, motorcycleSubcategories));
        vehicles.add(new Vehicle(R.drawable.bas, "Bus", false, busSubcategories));
        vehicles.add(new Vehicle(R.drawable.lori, "Lorry", false, lorrySubcategories));

        return vehicles;
    }
}
