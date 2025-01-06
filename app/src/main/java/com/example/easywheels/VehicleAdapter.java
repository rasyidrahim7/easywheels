package com.example.easywheels;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private List<Vehicle> vehicles;

    public VehicleAdapter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        Vehicle vehicle = vehicles.get(position);

        holder.vehicleTitleTextView.setText(vehicle.getTitle());
        holder.vehicleImageView.setImageResource(vehicle.getImageResId());

        // Handle expand/collapse for vehicle
        boolean isExpanded = vehicle.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.arrowImageView.setImageResource(isExpanded ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down);

        holder.arrowImageView.setOnClickListener(v -> {
            vehicle.setExpanded(!vehicle.isExpanded());
            notifyItemChanged(position);
        });

        // Populate subcategories without models
        holder.expandableLayout.removeAllViews();
        for (Vehicle.Subcategory subcategory : vehicle.getSubcategories()) {
            View subcategoryView = LayoutInflater.from(holder.itemView.getContext())
                    .inflate(R.layout.subcategory_item, holder.expandableLayout, false);
            TextView subcategoryTitle = subcategoryView.findViewById(R.id.subcategoryTitle);
            ImageView subcategoryArrow = subcategoryView.findViewById(R.id.subcategoryArrow);
            LinearLayout subcategoryExpandableLayout = subcategoryView.findViewById(R.id.subcategoryExpandableLayout);

            subcategoryTitle.setText(subcategory.getTitle());
            subcategoryExpandableLayout.setVisibility(subcategory.isExpanded() ? View.VISIBLE : View.GONE);
            subcategoryArrow.setImageResource(subcategory.isExpanded() ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down);

            subcategoryArrow.setOnClickListener(v -> {
                subcategory.setExpanded(!subcategory.isExpanded());
                notifyItemChanged(position);
            });

            // Add models under subcategory
            subcategoryExpandableLayout.removeAllViews();
            for (Vehicle.Subcategory.Model model : subcategory.getModels()) {
                TextView modelNameView = new TextView(holder.itemView.getContext());
                modelNameView.setText(model.getName());
                modelNameView.setTextSize(18);
                modelNameView.setPadding(20, 10, 20, 10);

                modelNameView.setOnClickListener(v -> {
                    Intent intent = new Intent(holder.itemView.getContext(), VehicleModelDetailsActivity.class);
                    intent.putExtra("modelName", model.getName());
                    intent.putExtra("price1", model.getPrice1());
                    intent.putExtra("price2", model.getPrice2());
                    intent.putExtra("imageResId1", model.getImageResId1());
                    intent.putExtra("imageResId2", model.getImageResId2());
                    holder.itemView.getContext().startActivity(intent);
                });

                subcategoryExpandableLayout.addView(modelNameView);
            }

            holder.expandableLayout.addView(subcategoryView);
        }
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    static class VehicleViewHolder extends RecyclerView.ViewHolder {
        TextView vehicleTitleTextView;
        ImageView vehicleImageView;
        ImageView arrowImageView;
        LinearLayout expandableLayout;

        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleTitleTextView = itemView.findViewById(R.id.vehicleTitleTextView);
            vehicleImageView = itemView.findViewById(R.id.vehicleImageView);
            arrowImageView = itemView.findViewById(R.id.arrowImageView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
        }
    }
}