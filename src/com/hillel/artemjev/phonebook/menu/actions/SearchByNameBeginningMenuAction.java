package com.hillel.artemjev.phonebook.menu.actions;

import com.hillel.artemjev.phonebook.contacts.ContactsList;
import com.hillel.artemjev.phonebook.menu.MenuAction;
import com.hillel.artemjev.phonebook.service.ContactsService;

import java.util.Scanner;

//Очень длинное название класса. Были варианты:
//- SearchByNameStartMenuAction
//- SearchByNameBeginMenuAction
//, но Start/Begin глаголы, могут сбить с толко о функциональности класса.

public class SearchByNameBeginningMenuAction implements MenuAction {

    private ContactsService contactsService;
    private Scanner sc;

    public SearchByNameBeginningMenuAction(ContactsService contactsService, Scanner sc) {
        this.contactsService = contactsService;
        this.sc = sc;
    }

    @Override
    public String getName() {
        return "Поиск по началу имени";
    }

    @Override
    public void doAction() {
        System.out.println("\n*********************************");
        System.out.println("Поиск по началу имени");
        System.out.print("Введите имя: ");
        String nameToSearch = sc.nextLine();

        ContactsList foundContactsList = contactsService.searchByNameBeginning(nameToSearch);

        if (foundContactsList.size() != 0) {
            System.out.println("Найдены следующие контакты:");
            for (int i = 0; i < foundContactsList.size(); i++) {
                System.out.printf("%3d - %s, %s\n", i + 1, foundContactsList.get(i).getName(),
                        foundContactsList.get(i).getPhone());

            }
        } else {
            System.out.println("Контакты не найдены.");
        }
        System.out.println("*********************************");
    }
}
