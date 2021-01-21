package model;

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




}
