package com.npci.model;

public enum DishType {
    MEAT, FISH, OTHER;
    public String toString() {
        return name().toLowerCase();
    }
}
