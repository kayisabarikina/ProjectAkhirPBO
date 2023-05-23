/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author HP
 */
public class Table_Model_Jam extends AbstractTableModel {
 List<ModelJam> listJam;
    public Table_Model_Jam(List<ModelJam> listJam){
        this.listJam = listJam;
    }
    @Override
    public int getRowCount() {
       return this.listJam.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }
    
    @Override
    public String getColumnName(int column){
     switch(column)   {
         case 0 : return "ID";
         case 1 : return "Jam";
         default : return null;
     }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return listJam.get(rowIndex).getId_jam();
            case 1 : return listJam.get(rowIndex).getJam();
            default : return null;
        }
    }
  
}   

