package model;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ManagerContact {
    List<Contacts> contactsList = new ArrayList<>();
    public static final String fileName = "contacts.csv";

    public List<Contacts> getContactsList() {
        return contactsList;
    }

    public void addNew(Contacts contacts) {
        contactsList.add(contacts);
        System.out.println("Thêm thành công");
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
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
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
            System.out.println("Không tìm được danh bạ với tên trên");
        }
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
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
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String string = "";
            for (Contacts contacts : contactsList) {
                string = contacts.getPhoneNumber() + "," + contacts.getGroup() + "," + contacts.getName() + "," + contacts.getGender()
                        + "," + contacts.getAddress() + "," + contacts.getBirthday() + "," + contacts.getEmail() + "\n";
                bufferedWriter.write(string);
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
