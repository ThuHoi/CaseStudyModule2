package controller;

import io.IoFileRoom;
import model.Room;
import validate.ValidateRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager {
    Scanner scanner = new Scanner(System.in);
    ValidateRoom validateRoom = new ValidateRoom();
    IoFileRoom ioFileRoom = new IoFileRoom();
    List<Room> roomList = ioFileRoom.readFile();


    public Room creatRoom() {
        String roomNane = validateRoom.validateRoomName(roomList);
        double price = validateRoom.validatePrice();
        String status = validateRoom.validateStatusRoom();
        int bedroomNumber = validateRoom.validateAmount("ngủ");
        int toiletNumber = validateRoom.validateAmount("wc");
        Room room = new Room(roomNane, price, status, bedroomNumber, toiletNumber);
        return room;

    }

    public void addRoom(Room room) {
        roomList.add(room);
        ioFileRoom.writeFile(roomList);
        System.out.println("✅ Thêm phòng thành công !!!");
    }

    public void editRoom() {
        System.out.print("┠ ▹ Nhập tên phòng muốn sửa: ");
        String roomName = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(roomName)) {
                roomList.set(i, creatRoom());
                ioFileRoom.writeFile(roomList);
                System.out.println("✅ Sửa phòng thành công !!!");
                isExist = true;
            }
        }
        if (!isExist) System.err.println("⛔ Tên phòng không tồn tại.");
    }

    public void deleteRoom() {
        System.out.print("┠ ▹ Nhập tên phòng muốn xóa: ");
        String roomName = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(roomName)) {
                roomList.remove(i);
                ioFileRoom.writeFile(roomList);
                System.out.println("✅ Xóa phòng thành công !!!");
                isExist = true;
            }
        }
        if (!isExist)
            System.err.println("⛔Tên phòng không tồn tại.");
            System.out.println();
    }

    public void searchByPriceAndStatus() {
        List<Room> rooms = new ArrayList<>();
        System.out.print("┠ ▹ Nhập giá phòng dưới: ");
        double priceMin = Double.parseDouble(scanner.nextLine());
        System.out.print("┠ ▹ Nhập giá phòng : ");
        double priceMax = Double.parseDouble(scanner.nextLine());
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getPriceRoom() >= priceMin && roomList.get(i).getPriceRoom() <= priceMax &&
                    roomList.get(i).getStatusRoom().equals("Phòng trống")) {
                rooms.add(roomList.get(i));
            }

        }
        try {
            System.out.println("----------------------------------------------------");
            System.out.printf("| %-15s| %-15s| %-15s|\n", "Tên", "Giá", "Trạng thái");
            System.out.println("----------------------------------------------------");
            for (Room room : rooms) {
                System.out.printf("| %-15s| %-15.2f| %-15s|", room.getNameRoom(), room.getPriceRoom(), room.getStatusRoom());
                System.out.println();
                System.out.println("----------------------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("⛔ Không tìm thấy phòng nào !!!");
            System.out.println("--------------------");
        }


    }

    public void displayRoomList() {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.isEmpty()) {
                System.out.println("⛔ Danh sách phòng chưa được cập nhật !!!");
                return;
            }
        }
        for (Room room : roomList) {
                System.out.println(room);
        }
    }
}


