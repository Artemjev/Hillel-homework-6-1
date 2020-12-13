package com.hillel.artemjev.phonebook.service;


import com.hillel.artemjev.phonebook.contacts.ContactsList;

public interface ContactsService {

    ContactsList getAll();

    void remove(int index);

    void add(String name, String phone);

    ContactsList searchByPhonePart(String phoneToSearch);

    ContactsList searchByNameBeginning(String nameToSearch);
}
