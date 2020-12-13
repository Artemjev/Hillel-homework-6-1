package com.hillel.artemjev.phonebook.service;

import com.hillel.artemjev.phonebook.contacts.Contact;
import com.hillel.artemjev.phonebook.contacts.ContactsList;


public class InMemoryContactsService implements ContactsService {

    private ContactsList contacts;

    public InMemoryContactsService() {
        contacts = new ContactsList();
    }

    @Override
    public ContactsList getAll() {
        return contacts;
    }

    @Override
    public void remove(int index) {
        contacts.remove(index);
    }

    @Override
    public void add(String name, String phone) {
        contacts.add(new Contact(name, phone));
    }

    @Override
    public ContactsList searchByPhonePart(String phoneToSearch) {
        ContactsList foundContactsList = new ContactsList();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhone().contains(phoneToSearch)) {
                foundContactsList.add(contacts.get(i));
            }
        }
        return foundContactsList;
    }

    @Override
    public ContactsList searchByNameBeginning(String nameToSearch) {
        ContactsList foundContactsList = new ContactsList();
        for (int i = 0; i < contacts.size(); i++) {
//          Поиск сделал регистронезависимым, поидее, с точки зрения юзабилити это правильно.
            if (contacts.get(i).getName().toUpperCase().startsWith(nameToSearch.toUpperCase())) {
                foundContactsList.add(contacts.get(i));
            }
        }
        return foundContactsList;
    }
}
