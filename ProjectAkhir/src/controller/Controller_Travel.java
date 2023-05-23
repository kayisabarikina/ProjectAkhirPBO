/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.DAOTravel;
import interfaceTravel.InterfaceTravel;
import interfaceTravel.InterfaceTravel;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelJam;
import model.ModelTravel;
import model.Table_Model_Travel;
import view.ViewTravel;
/**
 *
 * @author HP
 */
public class Controller_Travel {

    ViewTravel viewtravel;
    InterfaceTravel iTravel;
    List<ModelTravel> listTravel;

    public Controller_Travel(ViewTravel viewtravel) {
        this.viewtravel = viewtravel;
        iTravel = new DAOTravel();
    }
    
    public void readData() {
        listTravel = iTravel.getAll();
        Table_Model_Travel tabelTravel= new Table_Model_Travel(listTravel);
        viewtravel.getTableData().setModel(tabelTravel);
     }
    
    public void insertData(){
        ModelTravel travel= new ModelTravel();
        travel.setTujuan(viewtravel.getTujuan().getText());
        travel.setHarga(Integer.parseInt(viewtravel.getHarga().getText()));
        iTravel.insert(travel);
    }
   
    public void isiField(int row)
    {
    viewtravel.getIdTravel().setText(listTravel.get(row).getId_travel().toString());
    viewtravel.getTujuan().setText(listTravel.get(row).getTujuan());
    viewtravel.getHarga().setText(listTravel.get(row).getHarga().toString());
    
    
    }
    
    public void reset()
    {
       viewtravel.getIdTravel().setText("");
       viewtravel.getTujuan().setText("");
       viewtravel.getHarga().setText("");
    }
    
    public void update()
    {
        ModelTravel travel= new ModelTravel();
        travel.setId_travel(Integer.parseInt(viewtravel.getIdTravel().getText()));
        travel.setTujuan(viewtravel.getTujuan().getText());
        travel.setHarga(Integer.parseInt(viewtravel.getHarga().getText()));
        iTravel.update(travel);
    }
 
    public void delete() {
        ModelTravel travel = new ModelTravel();
        iTravel.delete(Integer.parseInt(viewtravel.getIdTravel().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
}
