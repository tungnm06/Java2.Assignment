/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.troller;

import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author Administrator
 */
public class StudentController {

    private static ArrayList<Student> listStudent;
    private StudentModel studentModel = new StudentModel();
    Student student = new Student();

    public void getList() {
        listStudent = studentModel.getListStudent();
        if (listStudent.isEmpty() == true) {
            System.out.println("Danh sach trong");

        } else {

            System.out.println("----------- List Student ------------");
            for (Student st : listStudent) {
                System.out.println("id: " + st.getId());
                System.out.println("name: " + st.getName());
                System.out.println("email: " + st.getEmail());
                System.out.println("class name: " + st.getClassName());
                System.out.println("roll number: " + st.getRollNumber());
                System.out.println("");

            };
        }
    }

    public void addStudent() {
        Student studentOld = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student infomation. ");
        System.out.println("Please enter name");
        String name = scanner.nextLine();

        System.out.println("Please enter email");
        String email = scanner.nextLine();

        System.out.println("Please enter rollNumber");
        String rollNumber = scanner.nextLine();

        System.out.println("Please enter classname");
        String className = scanner.nextLine();

        System.out.println("Please enter status");
        int status = scanner.nextInt();
        System.out.println("Name: " + name + ", Mail: " + email + ", RollNumber: " + rollNumber + ", ClassName : " + className + ", Status : " + status);
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setRollNumber(rollNumber);
        student.setClassName(className);
        student.setStatus(status);

        //     student.setId(System.currentTimeMillis());
        //. Luu thong tin sinh vien vao db.
        studentModel.insert(student);
    }

    public void editStudent() {

        Student studentOld = new Student();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter ID number Student :");
            String StrID = scanner.nextLine();
            int id = 0;
            int b = 0;

            try {
                id = Integer.parseInt(StrID);
            } catch (NumberFormatException e) {
                System.out.println("please enter Id is number " + e.getMessage());

            }
            studentOld = studentModel.getByID(id);
            if (studentOld != null) {
                System.out.println("Infomation student is ID = " + id);
                System.out.println("ID : " + studentOld.getId());
                System.out.println("Name : " + studentOld.getName());
                System.out.println("RollNumber : " + studentOld.getRollNumber());
                System.out.println("ClassName : " + studentOld.getClassName());
                System.out.println("Status : " + studentOld.getStatus());
                System.out.println("Edit Infomatinon student");
                System.out.println("Start Edit Infomation student :");
                System.out.println("Please enter new name");

                String name = scanner.nextLine();

                if (name.isEmpty() == true) {
                    name = studentOld.getName();

                }

                System.out.println("Please enter new email");
                String email = scanner.nextLine();
                if (email.isEmpty() == true) {
                    email = studentOld.getEmail();
                }
                System.out.println("Please enter new rollNumber");
                String rollNumber = scanner.nextLine();
                if (rollNumber.isEmpty() == true) {
                    rollNumber = studentOld.getRollNumber();
                }
                System.out.println("Please enter new classname");
                String className = scanner.nextLine();
                if (className.isEmpty() == true) {
                    className = studentOld.getClassName();
                }
                System.out.println("Please enter new status");
                int status = scanner.nextInt();
                System.out.println("Name: " + name + ", Mail: " + email + ", RollNumber: " + rollNumber + ", ClassName : " + className + ", Status : " + status);
                Student studentNew = new Student();
                studentNew.setName(name);
                studentNew.setEmail(email);
                studentNew.setRollNumber(rollNumber);
                studentNew.setClassName(className);
                studentNew.setStatus(status);
                studentNew.setId(id);
                studentModel.Update(studentNew);
                break;

            } else {
                System.out.println("Not found ID Student !!");
            }
        }
    }

    public void deleteStudent() {
        Student studentDelete = new Student();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter ID number Student :");
            String StrID = scanner.nextLine();
            int id = 0;
            try {
                id = Integer.parseInt(StrID);
            } catch (NumberFormatException e) {
                System.out.println("please enter Id is number " + e.getMessage());
            }
            studentDelete = studentModel.getByID(id);
            if (studentDelete != null) {
                System.out.println("Infomation student is ID = " + id);
                System.out.println("ID : " + studentDelete.getId());
                System.out.println("Name : " + studentDelete.getName());
                System.out.println("RollNumber : " + studentDelete.getRollNumber());
                System.out.println("ClassName : " + studentDelete.getClassName());
                System.out.println("Status : " + studentDelete.getStatus());
                studentModel.deleteId(id);

            } else {
                System.out.println("Student ID not found!!");
            }

        }
    }
}
