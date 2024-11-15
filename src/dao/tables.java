/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author GudaT
 */
public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = connectionprovider.getCon();
            st = con.createStatement();
            // st.executeUpdate("create table appuser(appuser_pk int Auto_INCREMENT primary key,userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50),address varchar (200),status varchar(50))");
            //st.executeUpdate(" insert into appuser (userRole,name,mobileNumber,email,password,address,status) values('superAdmin','super Admin','12345','superadmin@testemail.com','admin','ethiopia','Active')");
            //   st.executeUpdate("create table catagory (catagory_pk int Auto_INCREMENT primary key,name varchar(200))");
            // st.executeUpdate("create table product (product_pk int Auto_INCREMENT primary key,name varchar(200),quantity int ,price int,description varchar(500),catagory_FK int)");
            // st.executeUpdate("create table customer (customer_pk int Auto_INCREMENT primary key,name varchar(200),mobileNumber varchar(50),email varchar(200))");
            st.executeUpdate("create table orderdetail (order_pk int Auto_INCREMENT primary key,orderid varchar(200),customer_fk int,orderdate varchar(200),totalpaid int)");
            JOptionPane.showMessageDialog(null, "Table created successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }
}
