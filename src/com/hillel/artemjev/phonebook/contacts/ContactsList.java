package com.hillel.artemjev.phonebook.contacts;

import java.util.Arrays;


public class ContactsList {

    private static final int DEFAULT_CAPACITY = 4;
    private Contact[] contacts = new Contact[DEFAULT_CAPACITY];
    private int size;


    public Contact get(int index) {
        checkExistsIndex(index);
        return contacts[index];
    }

    public void set(int index, Contact contact) {
        checkExistsIndex(index);
        contacts[index] = contact;
    }

    public int size() {
        return size;
    }

    public void add(Contact contact) {
        ensureCapacity();
        contacts[size++] = contact;
    }

    public void remove(int index) {
        checkExistsIndex(index);
        for (int i = index; i < size - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        contacts[--size] = null;
    }

    @Override
    public String toString() {
        return "ContactList{" +
                "contacts=" + Arrays.toString(contacts) +
                ", size=" + size +
                '}';
    }

    //--------------------------------------------------------------------
    private void checkExistsIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity() {
        if (size == contacts.length) {
            contacts = Arrays.copyOf(contacts, newCapacity(contacts.length));
        }
    }

    private int newCapacity(int oldCapacity) {
        return oldCapacity + oldCapacity / 2 + oldCapacity % 2;
    }

}
