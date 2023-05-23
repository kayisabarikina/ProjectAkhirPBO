/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceTravel;

import java.util.List;
import model.ModelJam;
import model.ModelTravel;

/**
 *
 * @author HP
 */
public interface InterfaceJam {

    public List<ModelJam> getAll();

    public void insert(ModelJam jam);

    public void update(ModelJam jam);

    public void delete(int parseInt);

//    public List getById(int idJam);
}
