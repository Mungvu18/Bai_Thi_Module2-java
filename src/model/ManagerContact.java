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


}
