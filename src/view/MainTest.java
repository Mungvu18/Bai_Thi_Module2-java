package view;
import model.Contacts;
import java.util.Scanner;
import controller.ManagerContact;

import static constant.Constant_variable.*;
import static constant.Constant_variable.ENTER_NAME;
import static view.EnterDataForObject.*;

public class MainTest {
    static Scanner sc = new Scanner(System.in);
    static ManagerContact manageContacts = new ManagerContact();
  
    public static void main(String[] args) {
        runApp();
    }
    public static void runApp() {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                     manageContacts.showAll();
                    break;
                case 2:
                    System.out.println(ENTER_AMOUNT_OBJ_ADD);
                    int amount = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < amount; i++) {
                        Contacts contacts = setInformationContacts();
                        manageContacts.addNew(contacts);
                    }
                    break;
                case 3:
                    int index = -1;
                    String numberPhone2 = returnPhoneNumber();
                    if(numberPhone2.equals(NONE_OBJ)){
                        runApp();
                    }else {
                        do {
                            index = manageContacts.edit(numberPhone2);
                            if (index == -1) {
                                System.out.println(FIND_NOT_CONTACTS);
                            } else if (index >= 0 && index < manageContacts.getContactsList().size()) {
                                System.out.println(ENTER_DATA_OBJ);
                                Contacts contacts2 = setInformationContacts();
                                manageContacts.contactsList.set(index, contacts2);
                                System.out.println(SUCCESS);
                            }
                        } while (index < -1 && index >= manageContacts.contactsList.size());
                    }
                    break;
                case 4:
                    String numberPhone = returnPhoneNumber();
                    int index1 = manageContacts.remove(numberPhone);
                    if ((index1 > -1) && (index1 < manageContacts.contactsList.size())) {
                        String test = enterAgree();
                        if (test.equalsIgnoreCase(Y)) {
                            manageContacts.contactsList.remove(manageContacts.contactsList.get(index1));
                            manageContacts.writeFile();
                            System.out.println(DELETE_OBJ_SUCCESS);
                        } else {
                            MainTest.runApp();
                        }
                    } else {
                        System.out.println(NOT_FOUND_OBJ);
                    }
                    break;
                case 5:
                    String find = null;
                    boolean testFindWith2 = false;
                    boolean testFindWith1 = false;
                    do {
                        System.out.println(ENTER_CHOICE);
                        find = sc.nextLine();
                        testFindWith1 = find.equals(ONE);
                        if (testFindWith1) {
                            System.out.println(ENTER_NAME);
                            String name = sc.nextLine();
                            manageContacts.findByName(name);
                        } else {
                            testFindWith2 = find.equals(TWO);
                            if (testFindWith2) {
                                String numberPhone1 = returnPhoneNumber();
                                manageContacts.findByPhoneNumber(numberPhone1);
                            }
                        }
                    } while (testFindWith1 == false && testFindWith2 == false);
                    break;
                case 6:
                    manageContacts.readFile();
                    break;
                case 7:
                    manageContacts.writeFile();
                    break;
                case 8:
                    System.out.println(EXIT_PROGRAM);
                    break;
            }
        } while (choice != 8);
    }

    
}

