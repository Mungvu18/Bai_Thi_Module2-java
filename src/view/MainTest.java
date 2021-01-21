package view;
import model.Contacts;
import java.util.Scanner;
import controller.ManagerContact;

public class MainTest {
    static Scanner sc = new Scanner(System.in);
    static ManagerContact manageContacts = new ManagerContact();

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        int choice;
        do {
            System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ -----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát chương trình");
            System.out.println("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    if (manageContacts.contactsList == null) {
                        manageContacts.readFile();
                        manageContacts.showAll();
                    } else manageContacts.showAll();
                    break;
                case 2:
                    System.out.println("Nhập số lượng đối tượng muốn thêm");
                    int amount = sc.nextInt();
                    for (int i = 0; i < amount; i++) {
                        Contacts contacts = setInformationContacts();
                        manageContacts.addNew(contacts);
                    }
                    break;
                case 3:
                    int index = -1;
                    String numberPhone2 = returnPhoneNumber();
                    if(numberPhone2.equals("")){
                        runApp();
                    }else {
                        do {
                            index = manageContacts.edit(numberPhone2);
                            if (index == -1) {
                                System.out.println("Không tìm được danh bạ số điện thoại trên");
                            } else if (index >= 0 && index < manageContacts.getContactsList().size()) {
                                System.out.println("Nhập liệu đối tượng");
                                Contacts contacts2 = setInformationContacts();
                                manageContacts.contactsList.set(index, contacts2);
                                System.out.println("Cập nhật thành công");
                            }
                        } while (index < -1 && index >= manageContacts.contactsList.size());
                    }
                    break;
                case 4:
                    String numberPhone = returnPhoneNumber();
                    int index1 = manageContacts.remove(numberPhone);
                    if ((index1 > -1) && (index1 < manageContacts.contactsList.size())) {
                        String test = enterAgree();
                        if (test.equalsIgnoreCase("y")) {
                            manageContacts.contactsList.remove(manageContacts.contactsList.get(index1));
                            manageContacts.writeFile();
                            System.out.println("Xóa đối tượng thành công");
                        } else {
                            MainTest.runApp();
                        }
                    } else {
                        System.out.println("Không tìm được danh bạ với số điện thoại trên");
                    }
                    break;
                case 5:
                    String find = null;
                    boolean testFindWith2 = false;
                    boolean testFindWith1 = false;
                    do {
                        System.out.println("Nhập 1 nếu muốn tìm kiếm theo tên. Nhập 2 nếu muốn tìm kiếm theo số didenj thoại");
                        find = sc.nextLine();
                        testFindWith1 = find.equals("1");
                        if (testFindWith1) {
                            System.out.println("Nhập tên");
                            String name = sc.nextLine();
                            manageContacts.findByName(name);
                        } else {
                            testFindWith2 = find.equals("2");
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
                    System.out.println("Thoát chương trình");
                    break;
            }
        } while (choice != 8);
    }

    public static String enterAgree() {
        System.out.println("Nhập y nếu bạn đồng ý, để trống ấn Enter nếu muốn quay lại");
        String agree = sc.nextLine();
        return agree;
    }

    public static String returnPhoneNumber() {
        System.out.println("Nhập số điện thoại");
        String phoneNumber = sc.nextLine();
        return phoneNumber;
    }

    public static Contacts setInformationContacts() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String phoneNumber = sc1.nextLine();
        sc.nextLine();
        System.out.println("Nhập nhóm của danh bạ");
        String group = sc.nextLine();
        System.out.println("Nhập họ tên");
        String name = sc1.nextLine();
        System.out.println("Nhập giới tính");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = sc1.nextLine();
        System.out.println("Nhập ngày sinh");
        String birthday = sc.nextLine();
        System.out.println("Nhập email");
        String email = sc.nextLine();
        Contacts contacts = new Contacts(phoneNumber, group, name, gender, address, birthday, email);
        return contacts;
    }
}

