package com.npci.model;

import java.util.Objects;

public class Owner implements Comparable<Owner> {
    private String name;
    private String contactNumber;

    public Owner(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int compareTo(Owner o) {
        // Compare by name first, then by contact number
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return this.contactNumber.compareTo(o.contactNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(name, owner.name) && Objects.equals(contactNumber, owner.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contactNumber);
    }
}
