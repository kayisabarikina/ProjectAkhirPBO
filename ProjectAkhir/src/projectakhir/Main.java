/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectakhir;

import connection.KoneksiTravel;
import view.ViewHome;
import view.ViewLogin;

/**
 *
 * @author HP
 */
class Main {
    public static void main(String[] args){
     KoneksiTravel.getConnection();
     
     ViewHome viewHome = new ViewHome();
     viewHome.setVisible(true);
     viewHome.setLocationRelativeTo(null);
    }
}
