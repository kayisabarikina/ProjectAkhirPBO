/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOTravel;
import DAO.DAOJam;
import interfaceTravel.InterfaceJam;
import interfaceTravel.InterfaceOrder;
import interfaceTravel.InterfaceTravel;
import java.util.List;
import model.ModelJam;
import model.ModelOrder;
import model.ModelTravel;
import model.Table_Model_Jam;
import view.ViewJadwal;
import model.Table_Model_Travel;
import DAO.DAOorder;
import javax.swing.JOptionPane;
import model.ModelOrder;

import view.ViewShowTicket;

/**
 *
 * @author HP
 */
public class Controller_Order {
    
    ViewJadwal viewJadwal;
    InterfaceJam iJam;
    InterfaceTravel iTravel;
    InterfaceOrder iOrder;
    List<ModelJam> listJam;
    List<ModelTravel> listTravel;
    List<ModelOrder> listOrder;
    String tujuan, nama, nohp;
    Integer harga;
    String jam;
    
    public Controller_Order(ViewJadwal viewJadwal) {
        this.viewJadwal = viewJadwal;
        
        iJam = new DAOJam();
        iTravel = new DAOTravel();
        iOrder = new DAOorder();
    }
 
    
    public void readDataJam() {
        listJam = iJam.getAll();
        Table_Model_Jam tabelJam = new Table_Model_Jam(listJam);
        viewJadwal.getTableData2().setModel(tabelJam);
    }
    
    public void readDataTravel() {
        listTravel = iTravel.getAll();
        Table_Model_Travel tabelTravel = new Table_Model_Travel(listTravel);
        viewJadwal.getTableData().setModel(tabelTravel);
    }
 
    
    
    public void readFieldTravel(int row) {
        tujuan = listTravel.get(row).getTujuan();
        harga = Integer.valueOf(listTravel.get(row).getHarga().toString());
        
        viewJadwal.setTujuan(tujuan);
        viewJadwal.setHarga(harga);
    }
    
    public void readFieldJam(int row) {
        jam = listJam.get(row).getJam();
        viewJadwal.setJam(jam);
    }
    
    public void insertOrder() {
        nama = viewJadwal.getNama().getText();
        nohp = viewJadwal.getNohp().getText();
        try {
            ModelOrder order = new ModelOrder();
            order.setNama(nama);
            order.setNoHp(nohp);
            order.setTujuan(tujuan);
            order.setHarga(harga);
            order.setJam(jam);
            iOrder.insert(order);
            JOptionPane.showMessageDialog(null, "Insert Order Success");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        
    }
    

}
