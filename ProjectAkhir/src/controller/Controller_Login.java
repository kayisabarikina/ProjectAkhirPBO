/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import connection.KoneksiTravel;
import view.ViewLogin;
import java.sql.*;
import javax.swing.JOptionPane;
import view.ViewTravel;

/**
 *
 * @author HP
 */
public class Controller_Login {
 ViewLogin viewlogin;
 Connection connection;

    public Controller_Login(ViewLogin viewlogin) {
        this.viewlogin = viewlogin;
        connection= KoneksiTravel.getConnection();
    }
  public void login(){
      String username = viewlogin.getjUsername().getText();
      String password = viewlogin.getjPassword().getText();
      
      String cekUser = null;
      String cekPassword = null;
      
      try {
          Statement st = connection.createStatement();
          String query = "SELECT * FROM `admin` WHERE `username` = '" + username + "'AND password = '" + password + "'";
          ResultSet result = st.executeQuery(query);
          while(result.next()){
              cekUser = result.getString("username");
              cekPassword = result.getString("password");
          }
          result.close();
          st.close();
          
      } catch (Exception e) {
          System.out.println("Login Gagal");
      }
      
      if (cekUser == null && cekPassword == null){
          JOptionPane.showMessageDialog(null, "username atau password salah");
          viewlogin.setjUsername(null);
          viewlogin.setjPassword(null);
      } else{
          JOptionPane.showMessageDialog(null, "Login berhasil");
          new ViewTravel().setVisible(true);
          viewlogin.dispose();
      }
  }
 
 
}
