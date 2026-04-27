package com.dao;

import java.sql.*; 
import java.util.*;
import com.model.StudentMark;

public class MarkDAO {

    private String url = "jdbc:mysql://localhost:3306/studentdb";
    private String user = "root";
    private String pass = "@shalini075881";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // ADD (AUTO ID)
    public void addMark(StudentMark sm) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO StudentMarks (StudentName, Subject, Marks, ExamDate) VALUES (?, ?, ?, ?)"
        );

        ps.setString(1, sm.getStudentName());
        ps.setString(2, sm.getSubject());
        ps.setInt(3, sm.getMarks());
        ps.setDate(4, sm.getExamDate());

        ps.executeUpdate();
        con.close();
    }

    // UPDATE
    public void updateMark(StudentMark sm) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE StudentMarks SET StudentName=?, Subject=?, Marks=?, ExamDate=? WHERE StudentID=?"
        );

        ps.setString(1, sm.getStudentName());
        ps.setString(2, sm.getSubject());
        ps.setInt(3, sm.getMarks());
        ps.setDate(4, sm.getExamDate());
        ps.setInt(5, sm.getStudentID());

        ps.executeUpdate();
        con.close();
    }

    // DELETE
    public boolean deleteMark(int id) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM StudentMarks WHERE StudentID=?"
        );

        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        con.close();
        return rows > 0;
    }

    // GET ALL
    public List<StudentMark> getAllMarks() throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();

        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM StudentMarks");

        while (rs.next()) {
            StudentMark sm = new StudentMark();
            sm.setStudentID(rs.getInt(1));
            sm.setStudentName(rs.getString(2));
            sm.setSubject(rs.getString(3));
            sm.setMarks(rs.getInt(4));
            sm.setExamDate(rs.getDate(5));
            list.add(sm);
        }

        con.close();
        return list;
    }

    // TOTAL STUDENTS
    public int getTotalStudents() throws Exception {
        int count = 0;
        Connection con = getConnection();

        ResultSet rs = con.createStatement().executeQuery("SELECT COUNT(*) FROM StudentMarks");

        if (rs.next()) count = rs.getInt(1);

        con.close();
        return count;
    }

    // TOTAL SUBJECTS
    public int getTotalSubjects() throws Exception {
        int count = 0;
        Connection con = getConnection();

        ResultSet rs = con.createStatement().executeQuery(
            "SELECT COUNT(DISTINCT Subject) FROM StudentMarks"
        );

        if (rs.next()) count = rs.getInt(1);

        con.close();
        return count;
    }

    // AVERAGE MARKS
    public double getAverageMarks() throws Exception {
        double avg = 0;
        Connection con = getConnection();

        ResultSet rs = con.createStatement().executeQuery(
            "SELECT AVG(Marks) FROM StudentMarks"
        );

        if (rs.next()) avg = rs.getDouble(1);

        con.close();
        return avg;
    }

    // TOP MARKS
    public int getTopMarks() throws Exception {
        int top = 0;
        Connection con = getConnection();

        ResultSet rs = con.createStatement().executeQuery(
            "SELECT MAX(Marks) FROM StudentMarks"
        );

        if (rs.next()) top = rs.getInt(1);

        con.close();
        return top;
    }

    // REPORT METHODS
    public List<StudentMark> getAboveMarks(int m) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentMarks WHERE Marks > ?");
        ps.setInt(1, m);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            StudentMark sm = new StudentMark();
            sm.setStudentID(rs.getInt(1));
            sm.setStudentName(rs.getString(2));
            sm.setSubject(rs.getString(3));
            sm.setMarks(rs.getInt(4));
            sm.setExamDate(rs.getDate(5));
            list.add(sm);
        }

        con.close();
        return list;
    }

    public List<StudentMark> getBySubject(String sub) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentMarks WHERE Subject=?");
        ps.setString(1, sub);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            StudentMark sm = new StudentMark();
            sm.setStudentID(rs.getInt(1));
            sm.setStudentName(rs.getString(2));
            sm.setSubject(rs.getString(3));
            sm.setMarks(rs.getInt(4));
            sm.setExamDate(rs.getDate(5));
            list.add(sm);
        }

        con.close();
        return list;
    }

    public List<StudentMark> getTopN(int n) throws Exception {
        List<StudentMark> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?"
        );

        ps.setInt(1, n);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            StudentMark sm = new StudentMark();
            sm.setStudentID(rs.getInt(1));
            sm.setStudentName(rs.getString(2));
            sm.setSubject(rs.getString(3));
            sm.setMarks(rs.getInt(4));
            sm.setExamDate(rs.getDate(5));
            list.add(sm);
        }

        con.close();
        return list;
    }
}