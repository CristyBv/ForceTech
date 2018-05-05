package com.DB;

import java.sql.*;

/**
 * Created by CristyBv on 24-Mar-18.
 */
public class DB_user {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost/webapp?autoReconnect=true&useSSL=false";
    static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11227446?autoReconnect=true&useSSL=false";

    static final String USER = "sql11227446";
    static final String PASS = "5VHgIpJuWT";
    //static final String USER = "admin";
    //static final String PASS = "experimental112";

    public boolean isValidLogin(String name, String pass, String caut) throws ClassNotFoundException, SQLException {
        boolean isValid=false;

        Connection conn = null;
        Statement stmt = null;
        String sql="";

        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database (isValidUser)...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println(conn);
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        if(caut.compareTo("all")==0) sql="SELECT * FROM Users where user_name = \""+name+ "\" AND user_password = \"" + pass + "\"";
        else sql="SELECT * FROM Users where user_name = \""+name+ "\"";
        System.out.println(sql);

        ResultSet rez = stmt.executeQuery(sql);

        if(rez.next()) isValid=true;

        rez.close();
        stmt.close();
        conn.close();

        return isValid;
    }

    public void isRegistered(String user, String pass) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database (isRegistered)...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        System.out.println("Creating statement...");
        stmt = conn.createStatement();

        //sql = "insert into Users (user_name,user_password) values (\"" +sUserName+ "\",\"" + sUserPassword + "\")";
        sql = "insert into Users (user_name,user_password,now_registered,avatar_url) values (\"" +user+ "\",\"" + pass + "\",1,\"IMG/noavatar.png\")";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }

    public String getValue(String user, String pass, String value) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";
        String result="";

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database (getValue of "+ value + ")...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        System.out.println("Creating statement...");
        stmt = conn.createStatement();

        sql = "select "+value+" from Users where user_name = \""+user+ "\" AND user_password = \"" + pass + "\"";
        System.out.println(sql);

        ResultSet rez = stmt.executeQuery(sql);
        if(rez.next()){
            result = rez.getString(value);
        }
        stmt.close();
        conn.close();
        return result;
    }

    public void setValue(String user, String pass, String value1, String value2) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database (setValue "+value1+" - "+value2+")...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);

        System.out.println("Creating statement...");
        stmt = conn.createStatement();

        sql = "update Users set "+value1+"=\""+value2+"\" where user_name = \""+user+"\" and user_password = \""+pass+"\"";
        System.out.println(sql);
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
}
