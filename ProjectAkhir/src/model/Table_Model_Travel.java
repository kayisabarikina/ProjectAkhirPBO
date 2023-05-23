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
public class Table_Model_Travel extends AbstractTableModel {

    List<ModelTravel> listTravel;
    public Table_Model_Travel(List<ModelTravel> listTravel){
        this.listTravel = listTravel;
    }
    @Override
    public int getRowCount() {
       return this.listTravel.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }
    
    @Override
    public String getColumnName(int column){
     switch(column)   {
         case 0 : return "ID";
         case 1 : return "Tujuan";
         case 2 : return "Harga";
         default : return null;
     }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return listTravel.get(rowIndex).getId_travel();
            case 1 : return listTravel.get(rowIndex).getTujuan();
            case 2 : return listTravel.get(rowIndex).getHarga();
            default : return null;
        }
    }
  
}
