/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ModelTravel;
import connection.KoneksiTravel;
import interfaceTravel.InterfaceTravel;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class DAOTravel implements InterfaceTravel {

    Connection connect;

    public DAOTravel() {
        connect = KoneksiTravel.getConnection();
    }

    @Override
    public List<ModelTravel> getAll() {
        List<ModelTravel> listTravel = null;
        try {
            listTravel = new ArrayList<ModelTravel>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM travel");
            while (rs.next()) {
                ModelTravel tr = new ModelTravel();
                tr.setId_travel(rs.getInt("id_travel"));
                tr.setTujuan(rs.getString("tujuan"));
                tr.setHarga(rs.getInt("harga"));
                listTravel.add(tr);
            }

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return listTravel;
    }

    @Override
    public void insert(ModelTravel travel) {
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement("INSERT INTO travel (tujuan,harga) VALUES(?,?);");
            statement.setString(1, travel.getTujuan());
            statement.setInt(2, travel.getHarga());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Input Gagal(" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Input gagal");
            }

        }
    }

    @Override
    public void update(ModelTravel travel) {
        PreparedStatement statement = null;
        try {
            statement = connect.prepareStatement("UPDATE travel set tujuan=?, harga=? where id_travel=?;");
            statement.setString(1, travel.getTujuan());
            statement.setInt(2, travel.getHarga());
            statement.setInt(3, travel.getId_travel());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Update Gagal(" + e.getMessage() + ")");
        } finally {
            try {
                statement.close();
            } catch (SQLException exc) {
                System.out.println("Update gagal");
            }

        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;

        try {
            statement = connect.prepareStatement("DELETE FROM travel WHERE id_travel=?;");
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
