package com.example.easywheels;

import java.util.List;

public class Vehicle {
    private int imageResId;
    private String title;
    private boolean expanded;
    private List<Subcategory> subcategories;

    public Vehicle(int imageResId, String title, List<Subcategory> subcategories) {
        this.imageResId = imageResId;
        this.title = title;
        this.subcategories = subcategories;
        this.expanded = false; // Default to collapsed
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public static class Subcategory {
        private String title;
        private boolean expanded;
        private List<Model> models;

        public Subcategory(String title, List<Model> models) {
            this.title = title;
            this.models = models;
            this.expanded = false; // Default to collapsed
        }

        public String getTitle() {
            return title;
        }

        public boolean isExpanded() {
            return expanded;
        }

        public void setExpanded(boolean expanded) {
            this.expanded = expanded;
        }

        public List<Model> getModels() {
            return models;
        }

        public static class Model {
            private String name;
            private String price1;
            private String price2;
            private int imageResId1;
            private int imageResId2;

            public Model(String name, String price1, String price2, int imageResId1, int imageResId2) {
                this.name = name;
                this.price1 = price1;
                this.price2 = price2;
                this.imageResId1 = imageResId1;
                this.imageResId2 = imageResId2;
            }

            public String getName() {
                return name;
            }

            public String getPrice1() {
                return price1;
            }

            public String getPrice2() {
                return price2;
            }

            public int getImageResId1() {
                return imageResId1;
            }

            public int getImageResId2() {
                return imageResId2;
            }
        }
    }
}