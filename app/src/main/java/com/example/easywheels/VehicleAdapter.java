package com.example.easywheels;

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

        holder.iconImageView.setImageResource(vehicle.getIconResId());
        holder.titleTextView.setText(vehicle.getTitle());

        // Handle expand/collapse for vehicle
        boolean isExpanded = vehicle.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.arrowImageView.setImageResource(
                isExpanded ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down
        );

        holder.arrowImageView.setOnClickListener(v -> {
            vehicle.setExpanded(!vehicle.isExpanded());
            notifyItemChanged(position);
        });

        // Populate subcategories
        holder.expandableLayout.removeAllViews();
        for (Vehicle.Subcategory subcategory : vehicle.getSubcategories()) {
            // Add subcategory title with expand functionality
            View subcategoryView = LayoutInflater.from(holder.itemView.getContext())
                    .inflate(R.layout.subcategory_item, holder.expandableLayout, false);
            TextView subcategoryTitle = subcategoryView.findViewById(R.id.subcategoryTitle);
            ImageView subcategoryArrow = subcategoryView.findViewById(R.id.subcategoryArrow);
            LinearLayout subcategoryExpandableLayout = subcategoryView.findViewById(R.id.subcategoryExpandableLayout);

            subcategoryTitle.setText(subcategory.getTitle());
            subcategoryExpandableLayout.setVisibility(subcategory.isExpanded() ? View.VISIBLE : View.GONE);
            subcategoryArrow.setImageResource(
                    subcategory.isExpanded() ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down
            );

            subcategoryArrow.setOnClickListener(v -> {
                subcategory.setExpanded(!subcategory.isExpanded());
                notifyItemChanged(position);
            });

            // Add details under subcategory
            subcategoryExpandableLayout.removeAllViews();
            for (String detail : subcategory.getDetails()) {
                TextView detailView = new TextView(holder.itemView.getContext());
                detailView.setText("• " + detail);
                detailView.setPadding(20, 5, 10, 5);
                subcategoryExpandableLayout.addView(detailView);
            }

            holder.expandableLayout.addView(subcategoryView);
        }
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    static class VehicleViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;
        ImageView arrowImageView;
        LinearLayout expandableLayout;

        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            arrowImageView = itemView.findViewById(R.id.arrowImageView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
        }
    }
}
