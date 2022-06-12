package view;

import controller.AccountManager;
import controller.RoomManager;

import java.util.Scanner;

public class MenuLogin {
    private final Scanner scanner = new Scanner(System.in);
    AccountManager accountManager = new AccountManager();

    public void menuLogin() {
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("╔===================================================╗");
            System.out.println("║       ▂ ▃ ▅ ▆ █ QUẢN LÝ KHÁCH SẠN █ ▆ ▅ ▃ ▂       ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. Đăng nhập                                    ║");
            System.out.println("║>[2]. Đăng ký                                      ║");
            System.out.println("║>[0]. Thoát                                        ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.println();
                    System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                }
                switch (choice) {
                    case 1:
                        accountManager.login();
                        break;
                    case 2:
                        accountManager.registration();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }

            } catch (Exception e) {
                System.err.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
                menuLogin();
            }

        }
    }


}
