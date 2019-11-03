package com.example.demo.model;

import java.util.List;


public class Tags {

    List<String> categories;

    List<String> subcategories;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(final List<String> categories) {
        this.categories = categories;
    }

    public List<String> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(final List<String> subcategories) {
        this.subcategories = subcategories;
    }
}
