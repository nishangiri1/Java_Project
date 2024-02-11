package com.example.demo.detailss;
import com.example.demo.User;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoD {
    public Connection connect()throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","nishan","nishan");
        return  cn;
    }
        public boolean insert(User ua)
        {

            try {
                Connection cn=connect();
                PreparedStatement st=cn.prepareStatement("insert into Detail(name, roll, faculty) values (? ,? ,?)");
                st.setString(1,ua.getName());
                st.setInt(2,ua.getRoll());
                st.setString(3,ua.getFaculty());


                int i=st.executeUpdate();
                if(i>0)
                {
                    return true;
                }

                else {
                    System.out.println("Data inserted successfully");
                    return false;
                }
    }
            catch (Exception e)
                 {
                         e.getMessage();
                          System.out.println("Database not connected");
                           return false;
                 }
    }

    public List<User> selectALl()throws Exception{
        List<User> user=new ArrayList<User>();
        Connection cn=connect();
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("select * from Detail");
        while(rs.next())
        {
            User usr=new User();
            usr.setId(rs.getInt(4));
            usr.setName(rs.getString(1));
            usr.setRoll(rs.getInt(2));
            usr.setFaculty(rs.getString(3));
            user.add(usr);
        }
        return user;
    }
    public boolean delete(int id) throws Exception {
        try {
            Connection cn = connect();
            PreparedStatement st = cn.prepareStatement("delete from Detail where id=?");
            st.setInt(1, id);

            int i = st.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
    public boolean update(User user) throws Exception {
        try {
            Connection cn = connect();
            PreparedStatement st = cn.prepareStatement("update Detail set name=?, roll=?, faculty=? where id=?");
            st.setString(1, user.getName());
            st.setInt(2, user.getRoll());
            st.setString(3, user.getFaculty());
            st.setInt(4, user.getId());

            int i = st.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
}
