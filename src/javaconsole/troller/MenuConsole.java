/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.troller;

import java.util.Scanner;
import javaconsole.filehandle.FileHandle;

/**
 *
 * @author Administrator
 */
public class MenuConsole {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();

    }

    public void createMenu() {
        while (true) {

            System.out.println("======Student Manager======");
            System.out.println("1. Student list.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Delete student.");
            System.out.println("5. Export File");
            System.out.println("6. Import File");
            System.out.println("7. Exit");
            System.out.println("==========================");
            System.out.println("Please enter your choice:");
            // Yêu cầu người dùng nhập chuỗi kí tự, gán già trị người dùng nhập vào
            //ra biến kiểu chuỗi tên là strChoice.
            Scanner scanner = new Scanner(System.in);
            String strChoice = scanner.nextLine();

            // Kiểm tra dữ liệu người dùng nhập vào có là số hay không ?
            // Trong trường hợp không phải là số thì thông báo cho người dùng và bắt đầu lặp lại vòng lặp.
            int choice = 0;
            try {
                // Ep kiểu của biến strChoice về int.
                choice = Integer.parseInt(strChoice);

            } catch (java.lang.NumberFormatException e) {
                //Cần phần lưu log lỗi ở đấy.

                System.err.println("Please enter a number");
                continue;
            }

            StudentController studentController = new StudentController();
            FileHandle fileHandle = new FileHandle();

            if (choice == 7) {

                System.exit(0);

            } else {
                switch (choice) {
                    case 1:
                        // Do some thing .Please do something.
                        studentController.getList();
                        createMenu();

                    case 2:
                        // Do some thing .Please do something.
                        studentController.addStudent();
                        createMenu();

                    case 3:
                        // Do some thing .Please do something.
                        studentController.editStudent();
                        createMenu();

                    case 4:
                        // Do some thing .Please do something.
                        studentController.deleteStudent();
                        createMenu();

                    case 5:
                        // Do some thing .Please do something.
                        fileHandle.exportFile();
                        createMenu();

                    case 6:
                        // Do some thing .Please do something.
                        fileHandle.importFile();
                        createMenu();

                    default:
                        // Do some thing .Please do something.
                        System.out.println("Please enter number from 1 to 7");
                        break;
                }
            }

        }

    }
}
