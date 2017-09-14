/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaconsole.enity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author Administrator
 */
public class FileHandle {

    private static ArrayList<Student> listStudent;
    private StudentModel studentModel = new StudentModel();

    public void importFile() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String str;
            fr = new FileReader("hello.txt");
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                System.out.println(str);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        System.out.println("Import File thành công ! ");

    }

    public void exportFile() {

        listStudent = studentModel.getListStudent();
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter("hello.txt");
            bw = new BufferedWriter(fw);
//            fw.write("Nguyễn Văn Tú , Nguyễn Quỳnh Trang");
//            fw.close();
            for (Student student : listStudent) {
                bw.write("ID : " + student.getId());
                bw.newLine();
                bw.write("name: " + student.getName());
                bw.newLine();
                bw.write("email: " + student.getEmail());
                bw.newLine();
                bw.newLine();

            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Export File Thành công");
    }

}
