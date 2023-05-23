/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceTravel;
import java.util.List;
import model.ModelJam;
import model.ModelOrder;
import model.ModelTravel;

/**
 *
 * @author HP
 */
public interface InterfaceOrder {
    public List<ModelOrder> getAll();
    public void insert(ModelOrder order);
}
