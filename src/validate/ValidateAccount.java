package validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
        private static final String ACCOUNT_REGEX = "^(?=.*[a-z])(?=.*[0-9]).{8,12}$";
        private static final String PASS_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$]).{8,16}$";
        private static final String PHONE_REGEX = "^[(](\\+84)[)][-][0-9]{9,}$";
        private static final String EMAIL_REGEX = "^[a-z][a-z0-9]{0,9}\\.[a-z0-9]{1,10}@[a-z]+\\.(com|vn)+$";
        private static final String NAME_REGEX = "[A-Z][A-Za-z]+";
        private static final String ADDRESS_REGEX = "[A-Za-z0-9]+";
        private static final String AGE_REGEX = "18|(^[2-9][0-9])";


        private Scanner scanner = new Scanner(System.in);

        public String validateAccount() {
            while (true) {
                System.out.println(">[Chú ý]: Tài khoản phải từ 8 - 12 ký tự (a,1,...)");
                System.out.print("┠ ▹ Nhập tài khoản: ");
                String account = scanner.nextLine();
                Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
                Matcher matcher = pattern.matcher(account);
                if (matcher.matches()) {
                    return account;
                }
                System.out.println("⛔ Tài khoản không hợp lệ !!!");

            }
        }

        public String validatePassWord() {
            while (true) {
                System.out.println(">[Chú ý]: Mật khẩu phải từ 8 - 16 ký tự (a,A,1,...) bao gồm 1 ký tự đặc biệt (@,#,$)");
                System.out.print("┠ ▹ Nhập password: ");
                String password = scanner.nextLine();
                Pattern pattern = Pattern.compile(PASS_REGEX);
                Matcher matcher = pattern.matcher(password);
                if (matcher.matches()) {
                    return password;
                }
                System.out.println("⛔ Mật khẩu không hợp lệ !!!");

            }
        }

        public String validatePhoneNumber() {
            while (true) {
                System.out.println(">[Chú ý]: Số điện thoại phải có 10 số (0 - 9) định dạng: (+84)-911112222");
                System.out.print("┠ ▹ Nhập số điện thoại: ");
                String phone = scanner.nextLine();
                Pattern pattern = Pattern.compile(PHONE_REGEX);
                Matcher matcher = pattern.matcher(phone);
                if (matcher.matches()) {
                    return phone;
                }
                System.out.println("⛔ Số điện thoại không hợp lệ !!!");
            }
        }

        public String validateEmail() {
            while (true) {
                System.out.println(">[Chú ý]: Email phải có dạng: abc.company@yahoo.com/abc12.company@gmail.vn/...");
                System.out.print("┠ ▹ Nhập email: ");
                String inputEmail = scanner.nextLine();
                Pattern pattern = Pattern.compile(EMAIL_REGEX);
                Matcher matcher = pattern.matcher(inputEmail);
                if (matcher.matches()) {
                    return inputEmail;
                }
                System.out.println("⛔ Email không hợp lệ !!!");
            }
        }


        public String validateName() {
            while (true) {
                System.out.println(">[Chú ý]: Tên chữ cái đầu phải viết hoa");
                System.out.print("┠ ▹ Nhập tên: ");
                String name = scanner.nextLine();
                Pattern pattern = Pattern.compile(NAME_REGEX);
                Matcher matcher = pattern.matcher(name);
                if (matcher.matches()) {
                    return name;
                }
                System.out.println("⛔ Tên không hợp lệ !!!");
            }
        }




        public String validateAddress(){
            while (true){
                System.out.println(">[Chú ý]: Địa chỉ không thê ký tự đặc biệt");
                System.out.print("┠ ▹ Nhập địa chỉ: ");
                String address = scanner.nextLine();
                Pattern pattern = Pattern.compile(ADDRESS_REGEX);
                Matcher matcher = pattern.matcher(address);
                if (matcher.matches()){
                    return address;
                }
                System.out.println("⛔ Địa chỉ không hợp lệ !!!");
            }
        }
        public String validateAge() {
            while (true) {
                System.out.println(">[Chú ý]: Tuổi từ 18 ");
                System.out.print("┠ ▹ Nhập tuổi: ");
                String age = scanner.nextLine();
                Pattern pattern = Pattern.compile(AGE_REGEX);
                Matcher matcher = pattern.matcher(age);
                if (matcher.matches()) {
                    return age;
                }
                    System.out.println("⛔ Tuổi không hợp lệ !!!");

            }

        }

    }
