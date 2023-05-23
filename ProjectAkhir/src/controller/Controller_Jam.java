/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.DAOJam;
import interfaceTravel.InterfaceJam;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelJam;
import model.ModelTravel;
import model.Table_Model_Jam;
import view.ViewTravel;
/**
 *
 * @author HP
 */
public class Controller_Jam {

    ViewTravel viewtravel;
    InterfaceJam iTravel;
    List<ModelJam> listTravel;

    public Controller_Jam(ViewTravel viewtravel) {
        this.viewtravel = viewtravel;
        iTravel = new DAOJam();
    }
    
    public void readData() {
        listTravel = iTravel.getAll();
        Table_Model_Jam tabelTravel= new Table_Model_Jam(listTravel);
        viewtravel.getTableData2().setModel(tabelTravel);
    }
        
    public void insertData(){
        ModelJam jam=new ModelJam();
        jam.setJam(viewtravel.getJam().getText());
        
        iTravel.insert(jam);
     } 
    public void isiField(int row)
    {
        viewtravel.getIdJam().setText(listTravel.get(row).getId_jam().toString());
        viewtravel.getJam().setText(listTravel.get(row).getJam());
    }
    public void reset()
    {
       viewtravel.getIdJam().setText("");
       viewtravel.getJam().setText("");
      
    }
     public void update()
    {
        ModelJam jam= new ModelJam();
        jam.setId_jam(Integer.parseInt(viewtravel.getIdJam().getText()));
        jam.setJam(viewtravel.getJam().getText());
        iTravel.update(jam);
    }
    
  
    public void delete() {
         ModelJam jam = new ModelJam();
        iTravel.delete(Integer.parseInt(viewtravel.getIdJam().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
    }
 


