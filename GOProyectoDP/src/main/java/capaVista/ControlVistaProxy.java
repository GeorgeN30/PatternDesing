package capaVista;

import CapaControl.ControlFacade;
import capaModelo.Usuario;
import java.sql.Date;
import java.util.Calendar;

public class ControlVistaProxy implements IControlVista {
    private final ControlFacade controlFacade;

    public ControlVistaProxy() {
        // Crear una instancia local de ControlFacade
        this.controlFacade = new ControlFacade();
    }

    @Override
    public void registrarUsuario(String nombre, int edad, char sexo) {
        // Crear un objeto Usuario con los datos proporcionados
        Date fechaRegistro = new Date(Calendar.getInstance().getTimeInMillis());
        Usuario nuevoUsuario = new Usuario(0, nombre, edad, sexo, fechaRegistro);
        
        // Delegar la llamada al ControlFacade
        controlFacade.registrarUsuario(nuevoUsuario);
    }
    
     @Override
    public void actualizarUsuario(int id, String nombre, int edad, char sexo) {
        Date fechaRegistro = new Date(Calendar.getInstance().getTimeInMillis());
        Usuario usuario = new Usuario(id, nombre, edad, sexo,  fechaRegistro);
        controlFacade.actualizarUsuario(usuario);
    }
}
