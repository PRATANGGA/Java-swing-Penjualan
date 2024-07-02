/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.penjualan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class KoneksiMysql {
    String url, usr, pwd, dbn;
    public KoneksiMysql (String dbn) {
        this.url = "jdbc:mysql://localhost/" + dbn;
        this.usr = "root"; // Sesuaikan dengan username db anda
        this.pwd = ""; // Sesuaikan dengan password db anda
    }
    public KoneksiMysql (String host, String user, String pass,String dbn) {
        this.url = "jdbc:mysql://" + host + "/" + dbn;
        this.usr = user;
        this.pwd = pass;
    }
    
    public Connection getConnection() {
    Connection con = null;
    try {
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(this.url, this.usr, this.pwd);
    } catch (ClassNotFoundException e) {
        System.out.println ("Error #1 : " + e.getMessage());
        System.exit(0);
    } catch (SQLException e) {
        System.out.println ("Error #2 : " + e.getMessage());
        System.exit(0);
    }
        return con;
    }
    
    public static void main (String args[]) {
        KoneksiMysql kon = new KoneksiMysql ("pbo"); //Sesuaikan dengan nama database anda
        Connection c = kon.getConnection();
    }
    
}
