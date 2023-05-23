/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.KoneksiTravel;
import interfaceTravel.InterfaceOrder;
import java.util.List;
import model.ModelOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class DAOorder implements InterfaceOrder{
     Connection connect;
    
    public DAOorder(){
       connect = KoneksiTravel.getConnection();
    }

    @Override
    public List<ModelOrder> getAll() {
        List<ModelOrder> listOrder = null;
        try{
        listOrder = new ArrayList<ModelOrder>();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM `order`;");
            while(rs.next()) {
                ModelOrder jm = new ModelOrder();
                jm.setId_order(rs.getInt("id"));
                jm.setNama(rs.getString("nama"));
                jm.setNoHp(rs.getString("nohp"));
                jm.setTujuan(rs.getString("tujuan"));
                jm.setJam(rs.getString("jam"));
                jm.setHarga(Integer.parseInt(rs.getString("harga")));
                
                listOrder.add(jm);
            }
            
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
        }
        return listOrder;
    }

    @Override
    public void insert(ModelOrder order) {
        PreparedStatement statement = null;
        try{
           statement = connect.prepareStatement("INSERT INTO `order` (`nama`, `nohp`, `tujuan`, `jam`, `harga`) VALUES(?,?,?,?,?);");
        
           statement.setString(1, order.getNama());
           statement.setString(2, order.getNoHp());
           statement.setString(3, order.getTujuan());
           statement.setString(4, order.getJam());
           statement.setString(5, Integer.toString(order.getHarga()));
           
           statement.execute();
        }catch (SQLException e){
            System.out.println("Input Gagal("+ e.getMessage()+")");
        }finally{
            try{
                statement.close();
            }catch (SQLException exc){
                System.out.println("Input gagal");
            }   
    }
    }
}

