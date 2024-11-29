/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaVista;

import CapaControl.ControlFacade;
import capaModelo.Medicion;
import capaModelo.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author georg
 */
public class BuscarMedidasCommand implements Command {
    private int id;
    private ControlFacade controlFacade;
    private pnlConsultarMedidas view;  // Vista donde se actualizará la tabla

    public BuscarMedidasCommand(int id, ControlFacade controlFacade, pnlConsultarMedidas view) {
        this.id = id;
        this.controlFacade = controlFacade;
        this.view = view;
    }

    @Override
    public void execute() {
        // Llamar a ControlFacade para obtener el usuario y sus mediciones
        Usuario usuario = controlFacade.obtenerUsuario(id); // Obtener usuario por ID
        
        if (usuario != null) {
            List<Medicion> mediciones = controlFacade.obtenerMediciones(id); // Obtener mediciones del usuario
            view.mostrarMedidas(usuario, mediciones); // Actualizar la vista con los datos
        } else {
            JOptionPane.showMessageDialog(view, "No se encontró el usuario con ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
