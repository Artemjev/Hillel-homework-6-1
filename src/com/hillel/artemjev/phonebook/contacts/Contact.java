package com.hillel.artemjev.phonebook.contacts;


import java.util.Objects;

public class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name: " + name + ", phone: " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getName(), contact.getName()) &&
                Objects.equals(getPhone(), contact.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone());
    }
}
