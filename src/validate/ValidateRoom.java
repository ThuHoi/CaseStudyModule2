package validate;

import model.Room;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRoom {
    Scanner scanner = new Scanner(System.in);
    private final String NAME_REGEX = "^P[0-9]{3}";
    private final String PRICE_REGEX = "[0-9]+";
    private final String AMOUNT_REGEX = "[0-9]";

    public int getIndexRoomName(String nameRoom, List<Room> roomList) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getNameRoom().equals(nameRoom)) {
                return i;
            }
        }
        return -1;
    }

    public String validateRoomName(List<Room> roomList) {
        while (true) {
            try {
                System.out.print("┠ ▹ Nhập tên phòng: ");
                String nameRoom = scanner.nextLine();
                if (getIndexRoomName(nameRoom, roomList) != -1) {
                    throw new Exception();
                }
//                Pattern pattern = Pattern.compile(NAME_REGEX);
//                Matcher matcher = pattern.matcher(nameRoom);
                if (nameRoom.matches(NAME_REGEX)) {
                    return nameRoom;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("⛔ Tên phòng không hợp lệ !!!");
                System.out.println(">[Chú ý]: Tên phòng bắt đầu bằng P 3 chữ số");
            }
        }
    }

    public double validatePrice() {
        while (true) {
            System.out.print("┠ ▹ Nhập giá phòng: ");
            String price = scanner.nextLine();
            Pattern pattern = Pattern.compile(PRICE_REGEX);
            Matcher matcher = pattern.matcher(price);
            if (matcher.matches()) {
                return Double.parseDouble(price);
            }
            System.out.println("⛔ Giá phòng không hợp lệ !!!");
        }
    }


    public String validateStatusRoom() {
        while (true) {
            try {
                System.out.print("┠ ▹ Nhập trạng thái phòng: ");
                System.out.println();
                System.out.println("1. Phòng có khách thuê");
                System.out.println("2. Phòng trống");
                System.out.println("3. Phòng đang sửa");
                System.out.println("Nhập lựa chọn: ");
                String status = "";
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice <= 0 || choice >3) {
                    throw new Exception();
//                    System.out.println("Nhập sai. Mời nhập lại");
                }
                switch (choice) {
                    case 1:
                        status = "Phòng có khách thuê";
                        break;
                    case 2:
                        status = "Phòng trống";
                        break;
                    case 3:
                        status = "Phòng đang sửa";
                        break;
                }

                return status;

            } catch (Exception e) {
                System.out.println("⛔ Nhập sai yêu cầu, mời nhập lại");
            }
        }
    }


    public int validateAmount(String number) {
        while (true) {
            System.out.print("┠ ▹ Nhập số lượng phòng " + number + ": ");
            String amount = scanner.nextLine();
            Pattern pattern = Pattern.compile(AMOUNT_REGEX);
            Matcher matcher = pattern.matcher(amount);
            if (matcher.matches()) {
                return Integer.parseInt(amount);
            }
            System.out.println("⛔ Nhập số lượng không hợp lệ !!!");
        }
    }


}
