package org.example.mobile;

import java.util.ArrayList;
import java.util.List;


public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, ArrayList<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false; // zaten var...
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundIndex = findContact(oldContact);
        if (foundIndex < 0) {
            return false;
        }
        myContacts.set(foundIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundIndex = findContact(contact);
        if (foundIndex < 0) {
            return false;
        }
        myContacts.remove(foundIndex);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String ContactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(ContactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + contact.getPhoneNumber());
        }
    }
}
