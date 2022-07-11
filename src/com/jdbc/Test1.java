package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test1 {

    public static void main(String[] args) {

    Test1 obj=new Test1();
    try {
      obj.create(obj);
        obj.insert(obj);
      obj.update(obj);

    } catch (Exception e){
        e.printStackTrace();
    }

    }

    void create(Test1 obj) throws Exception{
        Connection conn = obj.connection();
        PreparedStatement st = conn.prepareStatement("create table student(s_id int(2),s_name varchar(100),s_age int(2))");
        int res = st.executeUpdate();
        if(res==1){
            System.out.println("Create");
        } else {
            System.out.println("Not Create");
        }
        conn.close();
    }

    void update(Test1 obj) throws Exception{
        Connection conn = obj.connection();
        PreparedStatement st = conn.prepareStatement("update student set s_name=?,s_age=? where s_id=?");
        st.setString(1,"ruma");
        st.setInt(2,87);
        st.setInt(3,2);
        int res = st.executeUpdate();
        if(res==1){
            System.out.println("data update");
        } else {
            System.out.println("Not data update");
        }
        conn.close();
    }
    void insert(Test1 obj) throws Exception{
        Connection conn = obj.connection();
        PreparedStatement st = conn.prepareStatement("insert into student(`s_id`,`s_name`,`s_age`)values(?,?,?)");
        st.setInt(1,3);
        st.setString(2,"sam");
        st.setInt(3,62);
        int res = st.executeUpdate();
        if(res==1){
            System.out.println("insert");
        } else {
            System.out.println("Not insert");
        }
        conn.close();
    }


    Connection connection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "ayasa";
        String password = "ayasa";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Successfully connected");
        return conn;
    }

}