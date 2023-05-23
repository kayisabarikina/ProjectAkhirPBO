/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceTravel;

import java.util.List;
import model.ModelTravel;

/**
 *
 * @author HP
 */
public interface InterfaceTravel {
    public List<ModelTravel> getAll();
//     public List<ModelTravel> getById(int parseInt);
    public void insert(ModelTravel travel);
    public void update(ModelTravel travel);
    public void delete(int parseInt);
    
}
