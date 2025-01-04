package com.example.easywheels;

import java.util.List;

public class Vehicle {
    private int iconResId;
    private String title;
    private boolean isExpanded;
    private List<Subcategory> subcategories;

    public Vehicle(int iconResId, String title, boolean isExpanded, List<Subcategory> subcategories) {
        this.iconResId = iconResId;
        this.title = title;
        this.isExpanded = isExpanded;
        this.subcategories = subcategories;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public static class Subcategory {
        private String title;
        private boolean isExpanded;
        private List<String> details;

        public Subcategory(String title, boolean isExpanded, List<String> details) {
            this.title = title;
            this.isExpanded = isExpanded;
            this.details = details;
        }

        public String getTitle() {
            return title;
        }

        public boolean isExpanded() {
            return isExpanded;
        }

        public void setExpanded(boolean expanded) {
            isExpanded = expanded;
        }

        public List<String> getDetails() {
            return details;
        }
    }
}

