package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public Connection connect()throws  Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","nishan","nishan");
        return connection;
    }


    public boolean signup(User user)
    {
        try {
            Connection cn=connect();
            PreparedStatement st=cn.prepareStatement("insert into Student values(?,?)");
            System.out.println("Database connected");
            st.setString(1,user.getEmail());
            st.setString(2,user.getPassword());
            int i=st.executeUpdate();
            if (i>0)
                return true;
            else
                return false;
        }
        catch (Exception e)
        {
            e.getMessage();
            System.out.println("Database not connected");
            return false;
        }

    }
    public boolean  authenticate(String email,String password)
    {
        try {
            Connection cn=connect();
            PreparedStatement st=cn.prepareStatement("select * from Student where email=? and password=?");
            System.out.println("Database connected");
            st.setString(1,email);
            st.setString(2,password);

           try( ResultSet resultSet=st.executeQuery())
           {
               return resultSet.next();
           }
        }
        catch (Exception e)
        {
            e.getMessage();
            System.out.println("Database not connected");
            return false;
        }

    }
}
