package view;

import controller.RoomManager;

import java.util.Scanner;

public class MenuRoom {
    Scanner scanner = new Scanner(System.in);
    RoomManager roomManager = new RoomManager();

    public void menuRoom() {
        while (true) {
            System.out.println("╔===================================================╗");
            System.out.println("║         ▂ ▃ ▅ ▆ █ QUẢN LÝ PHÒNG █ ▆ ▅ ▃ ▂         ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. Thêm phòng                                   ║");
            System.out.println("║>[2]. Sửa phòng                                    ║");
            System.out.println("║>[3]. Xóa phòng                                    ║");
            System.out.println("║>[4]. Hiển thị danh sách phòng                     ║");
            System.out.println("║>[5]. Tìm kiếm phòng còn trống theo giá            ║");
            System.out.println("║>[0]. Thoát                                        ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 5) {
                    throw new Exception();
                }
                switch (choice) {
                    case 1:
                        roomManager.addRoom(roomManager.creatRoom());
                        break;
                    case 2:
                        roomManager.editRoom();
                        break;
                    case 3:
                        roomManager.deleteRoom();
                        break;
                    case 4:
                        roomManager.displayRoomList();
                        break;
                    case 5:
                        roomManager.searchByPriceAndStatus();
                        break;
                    case 0:
                        return;
                }
            }catch (Exception e) {
                System.out.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
            }
        }
    }
}
