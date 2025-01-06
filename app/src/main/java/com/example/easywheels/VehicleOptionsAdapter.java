// src/com/example/easywheels/VehicleOptionsAdapter.java
package com.example.easywheels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VehicleOptionsAdapter extends RecyclerView.Adapter<VehicleOptionsAdapter.OptionViewHolder> {

    private List<String> options;

    public VehicleOptionsAdapter(List<String> options) {
        this.options = options;
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new OptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder holder, int position) {
        holder.optionTextView.setText(options.get(position));
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    static class OptionViewHolder extends RecyclerView.ViewHolder {
        TextView optionTextView;

        public OptionViewHolder(@NonNull View itemView) {
            super(itemView);
            optionTextView = itemView.findViewById(android.R.id.text1);
        }
    }
}