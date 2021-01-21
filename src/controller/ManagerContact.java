package controller;

import model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static constant.Constant_variable.*;

public class ManagerContact {
    public List<Contacts> contactsList = new ArrayList<>();
    public List<Contacts> getContactsList() {
        return contactsList;
    }

    public void addNew(Contacts contacts) {
        contactsList.add(contacts);
        System.out.println(SUCCESS);
    }

    public void showAll() {
        for (Contacts contacts : contactsList) {
            System.out.println(contacts);
        }
    }

    public int edit(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
            }
        }
        return index;
    }

    public int remove(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
            }
        }
        return index;
    }

    public void findByPhoneNumber(String phoneNumber) {
        boolean check = false;
        for (Contacts contacts : contactsList) {
            if (contacts.getPhoneNumber().contains(phoneNumber)) {
                System.out.println(contacts);
                check = true;
            }
        }
        if (check == false) {
            System.out.println(NOT_FOUND);
        }
    }

    public void findByName(String name) {
        boolean check = false;
        for (Contacts contacts : contactsList) {
            if (contacts.getName().contains(name)) {
                System.out.println(contacts);
                check = true;
            }
        }
        if (check == false) {
            System.out.println(NOT_FOUND);
        }
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(REGEX);
                Contacts contacts = new Contacts(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]);
                contactsList.add(contacts);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        showAll();
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String string = "";
            for (Contacts contacts : contactsList) {
                string = contacts.getPhoneNumber() + REGEX + contacts.getGroup() + REGEX + contacts.getName() + REGEX + contacts.getGender()
                        + REGEX + contacts.getAddress() + REGEX + contacts.getBirthday() + REGEX + contacts.getEmail() + "\n";
                bufferedWriter.write(string);
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
