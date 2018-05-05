package com.users;

import com.DB.DB_user;

import java.sql.SQLException;

public class UserData {
    public boolean isValidUser(String user,String pass, String caut) throws SQLException, ClassNotFoundException {
        DB_user object = new DB_user();
        return object.isValidLogin(user,pass,caut);
    }

    public void registerUser(String user, String pass) throws SQLException, ClassNotFoundException {
        DB_user object = new DB_user();
        object.isRegistered(user,pass);
    }

    public String getValueOf(String user, String pass, String value) throws SQLException, ClassNotFoundException {
        DB_user object = new DB_user();
        String result=object.getValue(user,pass,value);
        return result;
    }

    public void setValueOf(String user, String pass, String value1, String value2) throws SQLException, ClassNotFoundException {
        DB_user object = new DB_user();
        object.setValue(user,pass,value1,value2);
    }
}
