/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaceTravel.InterfaceJam;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelJam;
import connection.KoneksiTravel;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class DAOJam implements InterfaceJam{
    Connection connect;
    
    public DAOJam(){
       connect = KoneksiTravel.getConnection();
    }
    
    @Override
    public List<ModelJam> getAll() {
        List<ModelJam> listJam = null;
        try{
        listJam = new ArrayList<>();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM jam");
            while (rs.next()) {
                ModelJam jm = new ModelJam();
                jm.setId_jam(rs.getInt("id_jam"));
                jm.setJam(rs.getString("jam"));
                listJam.add(jm);
            }
            
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return listJam;
    }

    @Override
    public void insert(ModelJam jam) {
        PreparedStatement statement = null;
        try{
           statement = connect.prepareStatement("INSERT INTO jam (jam) VALUES(?);");
           statement.setString(1, jam.getJam());
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

    @Override
    public void update(ModelJam jam) {
        PreparedStatement statement = null;
        try{
            statement = connect.prepareStatement("UPDATE jam set jam=? where id_jam=?;");
            statement.setString(1, jam.getJam());
            statement.setInt(2, jam.getId_jam());
            
           
            statement.execute();
        }catch (SQLException e){
            System.out.println("Update Gagal("+ e.getMessage()+")");
        }finally{
            try{
                statement.close();
            }catch (SQLException exc){
                System.out.println("Update gagal");
            }   
            
        }
    }
    
    public void delete(int id) {
        PreparedStatement statement = null;
     
        try {
            statement = connect.prepareStatement("DELETE FROM jam WHERE id_jam=?;");
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Delete Gagal (" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Delete Gagal");
            }
        }
    }

    }


