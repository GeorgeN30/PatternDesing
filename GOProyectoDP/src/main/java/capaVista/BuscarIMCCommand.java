package capaVista;

import CapaControl.ControlFacade;
import capaModelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author georg
 */
public class BuscarIMCCommand implements Command {
    private int id;
    private ControlFacade controlFacade;
    private pnlConsultarIMC view;  // Vista donde se actualizará la tabla

    public BuscarIMCCommand(int id, ControlFacade controlFacade, pnlConsultarIMC view) {
        this.id = id;
        this.controlFacade = controlFacade;
        this.view = view;
    }

    @Override
    public void execute() {
        // Llamar a ControlFacade para obtener el usuario por ID
        Usuario usuario = controlFacade.obtenerUsuario(id);

        if (usuario != null) {
            // Obtener el IMC ya calculado (puedes obtenerlo de la base de datos o de alguna lógica previa)
            double imc = controlFacade.calcularYRegistrarIMC(id); // Método que obtiene el IMC ya registrado

            // Llamar al método en la vista para mostrar los resultados
            view.mostrarIMC(usuario, imc);
        } else {
            JOptionPane.showMessageDialog(view, "No se encontró el usuario con ID: " + id, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
