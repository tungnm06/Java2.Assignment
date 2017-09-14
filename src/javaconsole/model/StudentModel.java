/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javaconsole.enity.Student;

/**
 *
 * @author Administrator
 */
public class StudentModel {

    long startTime = System.currentTimeMillis();

    public static void main(String[] args) {

        StudentModel studentModel = new StudentModel();
        Student student01 = new Student();
        student01.setName("ManhDung4");
        student01.setEmail("manhdung4@gmail.com");
        student01.setRollNumber("A12346");
        student01.setClassName("C1702G");
        student01.setStatus(1);
        student01.setId(4);
        // studentModel.insert2(student01);
        // studentModel.Upadte(student01);
        //   studentModel.getListStudent();
        // Student student = studentModel.getByID(6);
        //   System.out.println(student.getName());
        studentModel.getByID(5);

    }

    public void insert2(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preSta = cnn.prepareStatement("INSERT INTO student (name, email, roll_number, class_name, status) "
                    + "VALUES(?, ?, ?, ?, ?);");
            preSta.setString(1, student.getName());
            preSta.setString(2, student.getEmail());
            preSta.setString(3, student.getRollNumber());
            preSta.setString(4, student.getClassName());
            preSta.setInt(5, student.getStatus());

            if (preSta.executeUpdate() > 0) {
                System.out.println("Insert thành công");
            } else {
                System.out.println("Lỗi khi thêm mới dữ liệu");
            }

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình insert dữ liệu. " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Thoi gian chay mat: " + (endTime - startTime));
    }

    // Insert thông tin sinh viên vao bảng student trong database studentmanager
    //insert into student(name.email....) values("Hung, Hung@gmail.com, ....)
    public void insert(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();

            StringBuilder sqlQueryBuilder = new StringBuilder();
            sqlQueryBuilder.append("INSERT INTO");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("student");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(name, email, roll_number, class_name, status)");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("VALUES");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("('"
                    + student.getName() + "', '"
                    + student.getEmail() + "', '"
                    + student.getRollNumber() + "','"
                    + student.getClassName() + "', "
                    + student.getStatus() + ");");
            System.out.println("Cau lenh SQL:");
            System.out.println(sqlQueryBuilder.toString());
            System.out.println("Ket Thuc Cau lenh SQL");

            stt.execute(sqlQueryBuilder.toString());
            System.out.println("Thành công");
        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình insert dữ liệu. " + e.getMessage());
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Thoi gian chay mat: " + (endTime - startTime));
    }

    public void deleteId(int id) {
        String sqlCommand = "delete from student where id = ?";

        try {

            Connection cnn = DAO.getConnection();
            PreparedStatement preSta = cnn.prepareStatement("delete from student where id = ?");

            preSta.setInt(1, id);

            if (preSta.executeUpdate() > 0) {
                System.out.println("Delete thành công");
            } else {
                System.out.println("Không có bản ghi nào được Delete");
            }

        } catch (SQLException e) {
            System.err.println("delete error !" + e.getMessage());
        }

    }

    public void Update(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preSta = cnn.prepareStatement("update student set name=?, email=?, roll_number=?, class_name=?, status=? where id =?");
            preSta.setString(1, student.getName());
            preSta.setString(2, student.getEmail());
            preSta.setString(3, student.getRollNumber());
            preSta.setString(4, student.getClassName());
            preSta.setInt(5, student.getStatus());
            preSta.setInt(6, student.getId());

            if (preSta.executeUpdate() > 0) {
                System.out.println("Update thành công");
            } else {
                System.out.println("Không có bản ghi nào được update");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi update bản ghi" + e.getMessage());

        }

    }

    public Student getByID(int id) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preSta = cnn.prepareStatement("SELECT * FROM student WHERE id = ? ;");
            preSta.setInt(1, id);
            ResultSet rs = preSta.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setClassName(rs.getString("class_name"));
                student.setStatus(rs.getInt("status"));
                return student;
            }
        } catch (SQLException e) {
            System.err.println("Select lỗi " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {

            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs;
            rs = stt.executeQuery("select * from student;");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setClassName(rs.getString("class_name"));
                student.setStatus(rs.getInt("status"));
                listStudent.add(student);
            }

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình lấy danh sách sinh viên " + e.getMessage());
        }
        return listStudent;

    }

}
