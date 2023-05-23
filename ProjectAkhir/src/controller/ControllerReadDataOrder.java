/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOorder;
import interfaceTravel.InterfaceJam;
import interfaceTravel.InterfaceOrder;
import interfaceTravel.InterfaceTravel;
import java.util.List;
import model.ModelJam;
import model.ModelTravel;
import view.ViewJadwal;
import view.ViewShowTicket;

/**
 *
 * @author HP
 */
public class ControllerReadDataOrder {
    ViewJadwal viewJadwal;
    ViewShowTicket viewTicket;
    InterfaceJam iJam;
    InterfaceTravel iTravel;
    InterfaceOrder iOrder;
    List<ModelJam> listJam;
    List<ModelTravel> listTravel;

    public ControllerReadDataOrder(ViewShowTicket viewTicket) {
        this.viewTicket = viewTicket;
    }

    public void readDataOrder(String nama, String nohp, String harga, String jam, String tujuan) {
        iOrder = new DAOorder();
        viewTicket.setVisible(true);
        viewTicket.getNama().setText(nama);
        viewTicket.getNohp().setText(nohp);
        viewTicket.getTujuan().setText(tujuan);
        viewTicket.getJam().setText(jam);
        viewTicket.getHarga().setText(harga);
    }
}
