/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmsproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mr Saurav
 */
public class DbClass {

    Connection con=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    DbClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/trdb";
            String username = "root";
            String password = "MySql@123";

            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void f1() {
        try {
            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created...");
            }
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void createUserDataTable() {
        try{
            String q = "CREATE TABLE UserData(Id int primary key auto_increment, Name varchar(200) not null, Email varchar(200) not null, Password varchar(200) not null, SignUpDate Date not null)";
            stmt = con.createStatement();
            stmt.executeUpdate(q);
            
//            stmt.close();
//            con.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    void insertDataInUserDataTable(String name, String email, String password){

        try {
            String q = "insert into UserData(Name, Email, Password, SignUpDate) values(?, ?, ?, NOW())";
            
            pstmt = con.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);

            pstmt.executeUpdate();
            
//            pstmt.close();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    boolean searchData(String email, String password){
        String quary = "SELECT * FROM userdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Password = '");
        quary = quary.concat(password);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            boolean state = rs.isBeforeFirst();
            
//            rs.close();;
//            stmt.close();
//            con.close();
            
            return state;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    boolean searchSubject(String email, String subject){
        String quary = "SELECT Subject FROM usertaskdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Subject = '");
        quary = quary.concat(subject);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            boolean state = rs.isBeforeFirst();
            
//            rs.close();;
//            stmt.close();
//            con.close();
            
            return state;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    String getDataNameFromTable(String email, String password){
        String name=null;
        
        String quary = "SELECT * FROM userdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Password = '");
        quary = quary.concat(password);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            rs.next();
            
            name = rs.getString("Name");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
    void createTask1DataTable() {
        try{
            String q = "CREATE TABLE UserTask1Data(Id int primary key auto_increment, Name varchar(200) not null, Email varchar(200) not null, Subject varchar(200) not null, Hour double(30) not null)";
            stmt = con.createStatement();
            stmt.executeUpdate(q);
            
//            stmt.close();
//            con.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void insertDataInUserTask1DataTable(String name, String email, String subject, double hours){

        try {
            String q = "insert into UserTask1Data(Name, Email, Subject, Hour) values(?, ?, ?, ?)";
            
            pstmt = con.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, subject);
            pstmt.setDouble(4, hours);

            pstmt.executeUpdate();
            
//            pstmt.close();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void createSetTaskTable() {
        try{
            String q = "CREATE TABLE UserTaskData(Id int primary key auto_increment, Name varchar(200) not null, Email varchar(200) not null, Subject varchar(200) not null, HourNeed float(30), QuestionHave int(30) not null, EndDate varchar(50) not null, DSHour float(30) not null, DQSolve int(30) not null, SetTaskDate Date)";
            stmt = con.createStatement();
            stmt.executeUpdate(q);
            
//            stmt.close();
//            con.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void insertDataInSetTaskTable(String name, String email, String subject, double hourNeed, int QuestionHave, String endDate, double dsHours, int dqsolve){

        try {
            String q = "insert into UserTaskData(Name, Email, Subject, HourNeed, QuestionHave, EndDate, DSHour, DQSolve, SetTaskDate) values(?, ?, ?, ?, ?, ?, ?, ?, NOW())";
            
            pstmt = con.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, subject);
            pstmt.setDouble(4, hourNeed);
            pstmt.setInt(5, QuestionHave);
            pstmt.setString(6, endDate);
            pstmt.setDouble(7, dsHours);
            pstmt.setInt(8, dqsolve);

            pstmt.executeUpdate();
            
//            pstmt.close();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ArrayList<String> getDataFromUserTaskDataTable(String name, String email){

        ArrayList<String> a = new ArrayList<String>();
        
        String quary = "SELECT * FROM usertaskdata WHERE Name = '";
        quary = quary.concat(name);
        quary = quary.concat("' AND Email = '");
        quary = quary.concat(email);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            while(rs.next()){
                a.add(rs.getString("Subject"));
                a.add(Double.toString(rs.getDouble("HourNeed")));
                a.add(Integer.toString(rs.getInt("QuestionHave")));
                a.add(rs.getString("EndDate"));
                a.add(Double.toString(rs.getDouble("DSHour")));
                a.add(Integer.toString(rs.getInt("DQSolve")));
                a.add(rs.getDate("SetTaskDate").toString());                
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    void createUpdateTaskTable() {
        try{
            String q = "CREATE TABLE UserUpdateTaskData(Id int primary key auto_increment, Name varchar(200) not null, Email varchar(200) not null, Subject varchar(200) not null, StudyHour float(30), QuestionSolve int(30) not null, UpdateDate Date)";
            stmt = con.createStatement();
            stmt.executeUpdate(q);
            
//            stmt.close();
//            con.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void insertDataInUserUpdateTaskDataTable(String name, String email, String subject, double studyHour, double questionSolve){

        try {
            String q = "insert into UserUpdateTaskData(Name, Email, Subject, StudyHour, QuestionSolve, UpdateDate) values(?, ?, ?, ?, ?, NOW())";
            
            pstmt = con.prepareStatement(q);
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, subject);
            pstmt.setDouble(4, studyHour);
            pstmt.setDouble(5, questionSolve);

            pstmt.executeUpdate();
            
//            pstmt.close();
//            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    boolean searchDifferentUpadateData(String email, String subject, String date){
        String quary = "SELECT * FROM userupdatetaskdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND UpdateDate = '");
        quary = quary.concat(date);
        quary = quary.concat("' AND Subject = '");
        quary = quary.concat(subject);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            boolean state = rs.isBeforeFirst();
            
//            rs.close();;
//            stmt.close();
//            con.close();
            
            return (state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    void UpdateTaskInUserUpdateTaskDataTable(String email, String subject, double todayStudyHours, double todayQuestionSolve){
        String q = "UPDATE userupdatetaskdata SET StudyHour = ?, QuestionSolve = ? WHERE Email = ? AND Subject = ?";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setDouble(1, todayStudyHours);
            pstmt.setDouble(2, todayQuestionSolve);
            pstmt.setString(3, email);
            pstmt.setString(4, subject);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    double getTotalStudyHours(String email, String subject){

        double totalStudyHours=0;
        
        String quary = "SELECT * FROM userupdatetaskdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Subject = '");
        quary = quary.concat(subject);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            while(rs.next()){
                totalStudyHours += rs.getDouble("StudyHour");
            }
            return totalStudyHours;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalStudyHours;
    }
    int getTotalQuestionSolve(String email, String subject){

        int totalQuestionSolve=0;
        
        String quary = "SELECT * FROM userupdatetaskdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Subject = '");
        quary = quary.concat(subject);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            while(rs.next()){
                totalQuestionSolve += rs.getInt("QuestionSolve");
            }
            return totalQuestionSolve;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalQuestionSolve;
    }
    ArrayList getDailyStudyHoursTargetAndDate(String email, String subject){

        ArrayList a = new ArrayList(2);
        
        String quary = "SELECT * FROM usertaskdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Subject = '");
        quary = quary.concat(subject);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            while(rs.next()){
                a.add(rs.getDouble("DSHour"));
                a.add(rs.getDate("SetTaskDate").toString());
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    ArrayList getDailyQuestionSolveTargetAndDate(String email, String subject){

        ArrayList a = new ArrayList(2);
        
        String quary = "SELECT * FROM usertaskdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("' AND Subject = '");
        quary = quary.concat(subject);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            while(rs.next()){
                a.add(rs.getInt("DQSolve"));
                a.add(rs.getDate("SetTaskDate").toString());
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    void UpdatePasswordInUserTaskDataTable(String email, String newPassword){
        String q = "UPDATE userdata SET  Password = ? WHERE Email = ?";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    boolean searchEmail(String email){
        String quary = "SELECT Email FROM userdata WHERE Email = '";
        quary = quary.concat(email);
        quary = quary.concat("'");
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(quary);
            
            boolean state = rs.isBeforeFirst();
            
//            rs.close();;
//            stmt.close();
//            con.close();
            
            return state;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    void closeConnection(){
        try {
            stmt.close();
            pstmt.close();
            rs.close();
            con.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        DbClass db = new DbClass();
        db.createSetTaskTable();
    }
}
