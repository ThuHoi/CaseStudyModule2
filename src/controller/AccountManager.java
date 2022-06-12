package controller;

import io.IoFileAccount;
import model.Account;
import validate.ValidateAccount;
import view.MenuLogin;
import view.MenuRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {

    ValidateAccount validateAcc = new ValidateAccount();
    Account account = new Account();
    MenuRoom menuRoom = new MenuRoom();
    RoomManager roomManager = new RoomManager();
    IoFileAccount ioFileAccount = new IoFileAccount();

    List<Account> accountList = IoFileAccount.readFile();

    {
        if (accountList.size() == 0)
            accountList.add(new Account("thuhoi0205", "Thuhoi0205$", "Thu hoi", "18", "(+84)-793267128", "Hai Phong", "thuhoi0205.company@gmail.vn", "Manager"));
    }

    Scanner scanner = new Scanner(System.in);

    public void registration() {
        System.out.println("┎──────────────[ĐĂNG KÝ]──────────────┒");
        String accountName = validateAcc.validateAccount();
        String passWord = validateAcc.validatePassWord();
        String name = validateAcc.validateName();
        String age = validateAcc.validateAge();
        String phone = validateAcc.validatePhoneNumber();
        String address = validateAcc.validateAddress();
        String email = validateAcc.validateEmail();
        String role = "Staff";
        System.out.println("┖─────────────────────────────────────┚");

        accountList.add(new Account(accountName, passWord, name, age, phone, address, email, role));

        ioFileAccount.writeFile(accountList);
        System.out.println("✅ Đăng ký tài khoản thành công!!!");

    }

    public void login() {
        System.out.println("┎──────────────[ĐĂNG NHẬP]──────────────┒");
        System.out.print(" ┠ ▹ Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.print(" ┠ ▹ Nhập mật khẩu: ");
        String password = scanner.nextLine();
        System.out.println("┖───────────────────────────────────────┚");


        for (Account acc : accountList) {
            if (acc.getAccountName().equals(account) && acc.getPassWord().equals(password)) {
                System.out.println("Xin chào " + acc.getUserName());
                if (acc.getRole().equals("Manager")) {
                    menuManager(acc);
                } else {
                    menuStaff(acc);
                }
                return;
            }
            System.out.println("⛔ Không tìm thấy account");
        }
    }

    public Account createAccount() {
        String accountName = account.getAccountName();
        String passWord = validateAcc.validatePassWord();
        String userName = validateAcc.validateName();
        String age = validateAcc.validateAge();
        String numberPhone = validateAcc.validatePhoneNumber();
        String address = validateAcc.validateAddress();
        String email = validateAcc.validateEmail();
        String role = "staff";
        Account account = new Account(accountName, passWord, userName, age, numberPhone, address, email, role);
        return account;

    }


    public void editAccount() {
        System.out.print("┠ ▹ Nhập tên user muốn sửa: ");
        String accountName = scanner.nextLine();
        boolean checkEdit = false;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountName().equals(accountName)) {
                accountList.set(i, createAccount());
                ioFileAccount.writeFile(accountList);
                System.out.println("✅ Sửa tên tài khoản thành công !!!");
                checkEdit = true;
                break;
            }
        }
        if (!checkEdit)
        System.err.println("⛔ Tên tài khoản không tồn tại.");
        System.out.println();
    }

    public void deleteAccount() {
        System.out.print("┠ ▹ Nhập tên xóa: ");
        String accountName = scanner.nextLine();
        boolean checkDelete = false;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountName().equals(accountName)) {
                accountList.remove(i);
                ioFileAccount.writeFile(accountList);
                System.out.println("✅ Xóa tên tài khoản thành công !!!");
                checkDelete = true;
            }

        }
        if (!checkDelete)
        System.err.println("⛔ Tên taì khoản không tồn tại.");
        System.out.println();
    }

    public void displayAccountList() {
        for (Account acc : accountList) {
            System.out.println(acc);
        }
    }

    public void searchAccount() {
        List<Account> accounts = new ArrayList<>();
        System.out.print("┠ ▹ Nhập tên: ");
        String userName = scanner.nextLine();
        for (Account acc : accountList) {
            if (acc.getUserName().equals(userName)) {
                accounts.add(acc);
            }

        }
        try {
            for (Account acc : accounts) {
                System.out.println(acc);

            }
        } catch (Exception e) {
            System.out.println("⛔ Không tìm thấy " + userName + " !!!");
        }
    }

    public void exit() {
        System.out.println("⛔ Đã thoát khỏi hệ thống !!!");
        (new MenuLogin()).menuLogin();
    }

    public void menuManager(Account account) {
        while (true) {
            System.out.println("╔===================================================╗");
            System.out.println("║         ▂ ▃ ▅ ▆ █ HỆ THỐNG MANAGER █ ▆ ▅ ▃ ▂      ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. Quản lý phòng                                ║");
            System.out.println("║>[2]. Hiển thị thông tin USER                      ║");
            System.out.println("║>[3]. Sửa USER                                     ║");
            System.out.println("║>[4]. Xóa USER                                     ║");
            System.out.println("║>[0]. Đăng xuất                                    ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        menuRoom.menuRoom();
                        break;
                    case 2:
                        System.out.println(account.toString());
                        break;
                    case 3:
                        editAccount();
                        break;
                    case 4:
                        deleteAccount();
                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        System.err.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                }
            } catch (Exception e) {
                System.out.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
            }
        }
    }

    public void menuStaff(Account account) {
        while (true) {
            System.out.println("╔===================================================╗");
            System.out.println("║         ▂ ▃ ▅ ▆ █ HỆ THỐNG STAFF █ ▆ ▅ ▃ ▂        ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. Hiển thị danh sách phòng                     ║");
            System.out.println("║>[2]. Hiển thị danh sách account                   ║");
            System.out.println("║>[3]. Tìm kiếm phòng còn trống theo giá            ║");
            System.out.println("║>[4]. Quản lý phòng                                ║");
            System.out.println("║>[5]. Hiển thị danh sách account                   ║");
            System.out.println("║>[0]. Đăng xuất                                    ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        roomManager.displayRoomList();
                        break;
                    case 2:
                        roomManager.searchByPriceAndStatus();
                        break;
                    case 3:
                        displayAccountList();
                        break;
                    case 4:
                        menuRoom.menuRoom();
                        break;
                    case 0:
                        exit();
                        break;
                }
            } catch (Exception e) {
                System.out.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
            }


        }
    }


}
