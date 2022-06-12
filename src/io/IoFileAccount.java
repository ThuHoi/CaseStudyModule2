package io;


import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IoFileAccount<E> {
    public void writeFile(List<Account> accounts) {
        File file = new File("D:\\CaseStudy_Module2\\fileData\\account.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account account : accounts) {
                bufferedWriter.write(account.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("✅ Viết file account thành công !!!");
        } catch (IOException e) {
            System.err.println("⛔ File không tồn tại.");

        }

    }

    public static List<Account> readFile() {
        List<Account> accountList = new ArrayList<>();
        File file = new File("D:\\CaseStudy_Module2\\fileData\\account.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String accountName = arr[0];
                String passWord = arr[1];
                String userName = arr[2];
                String age = arr[3];
                String numberPhone = arr[4];
                String address = arr[5];
                String email = arr[6];
                String role = arr[7];
                accountList.add(new Account(accountName,passWord,userName,age,numberPhone,address,email,role));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("✅ Đọc file account thành công !!!");
        } catch (IOException e) {
            System.err.println("⛔ File không tồn tại.");
        }
        return accountList;
    }


}
