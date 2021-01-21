package view;

import model.Contacts;

import java.util.Scanner;

import static constant.Constant_variable.*;

public class EnterDataForObject {
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        System.out.println(APP);
        System.out.println(ENTER_FUNCTION);
        System.out.println(SEE_LIST);
        System.out.println(ADD_NEW);
        System.out.println(EDIT);
        System.out.println(DELETE);
        System.out.println(FIND);
        System.out.println(READ_FILE);
        System.out.println(WRITE_FILE);
        System.out.println(EXIT_APP);
        System.out.println(ENTER_FUNCTION);
    }

    public static String enterAgree() {
        System.out.println(ENTER_Y_AGREE_ENTER_NULL_BACCK);
        String agree = sc.nextLine();
        return agree;
    }

    public static String returnPhoneNumber() {
        String phoneNumber = NULL;
        do {
            System.out.println(ENTER_PHONE_NUMBER);
            phoneNumber = sc.nextLine();
            return phoneNumber;
        }while (!phoneNumber.matches(REGEX_NUMBER_PHONE));
    }

    public static Contacts setInformationContacts() {
        Scanner sc1 = new Scanner(System.in);
        String phoneNumber = NULL;
        do {
            System.out.println(ENTER_PHONE_NUMBER_INTO_ZERO_NICE);
            phoneNumber = sc.nextLine();
        }while (!phoneNumber.matches(REGEX_NUMBER_PHONE));
        System.out.println(GROUP);
        String group = sc.nextLine();
        System.out.println(ENTER_NAME);
        String name = sc1.nextLine();
        System.out.println(ENTER_GENGER);
        String gender = sc.nextLine();
        System.out.println(ENTER_ADDRESS);
        String address = sc1.nextLine();
        System.out.println(ENTER_BIRTHDAY);
        String birthday = sc.nextLine();
        String email = NULL;
        do {
            System.out.println(ENTER_EMAIL);
            email = sc.nextLine();
        }while (!email.matches(REGEX_EMAIL));
        Contacts contacts = new Contacts(phoneNumber, group, name, gender, address, birthday, email);
        return contacts;
    }
}
